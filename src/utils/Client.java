package utils;

import controller.MainScreenController;
import controller.PromptWindowsController;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket client;
    private DataOutputStream dos;

    public Client() {
        System.out.println("-----Client------");
        //建立连接：使用Socket创建客户端 + 服务的地址和端口
        try {
            this.client = new Socket("localhost", 8888);
            this.dos = new DataOutputStream(client.getOutputStream());
            new Thread(new Receive(client)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器发送消息
    public void send(String msg) {
        try {
            this.dos.writeUTF(msg);
            this.dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器上传文件
    public void sendFile(String userId, String fileName, String path) {
        //弹出提示窗口
        PromptWindowsController.showPromptWindows("开始上传");
        send("sendFile|" + userId + "|" + fileName);
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(path + fileName));
            byte[] bytes = new byte[1024 * 1024 * 10];
            int len = -1;
            while((len = bis.read(bytes)) != -1) {
                dos.write(bytes, 0, len);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void close(String userId) {
        send("close|" + userId);
    }

    static class Receive implements Runnable {
        private DataInputStream dis;

        public Receive(Socket client) {
            try {
                this.dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //接收服务器转发过来的数据
        public String receive() {
            String msg = null;
            try {
                msg = this.dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return msg;
        }


        @Override
        public void run() {
            while(true) {
                String msg = receive();
                if(msg != null) {
                    String[] arr = msg.split("\\|");
                    if(arr[0].equals("getPath")) {
                        //如何将路径传输到主界面里面去
                        MainScreenController.path = arr[1];
                    }
                }
            }
        }
    }
}
