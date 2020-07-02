package utils;

import controller.PromptWindowsController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Channel> administrationMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("-----Server------");
        ServerSocket server = null;
        try {
            server = new ServerSocket(8888);
            while (true) {
                //接收一个登录的客户端
                Socket client = server.accept();
                Channel channel = new Channel(client);
                System.out.println("一个客户端建立了连接");
                new Thread(channel).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Channel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String userId;

        public Channel(Socket client) {
            try {
                this.client = client;
                this.dis = new DataInputStream(client.getInputStream());
                this.dos = new DataOutputStream(client.getOutputStream());
                this.isRunning = true;
                this.userId = receive();
                System.out.println(userId);
                administrationMap.put(this.userId, this);
                //创建该用户存储文件的文件夹
                File file = new File("disk/" + this.userId);
                if(!file.exists()) {
                    file.mkdir();
                }
            } catch (IOException e) {
                release();
            }
        }

        //发送消息
        private void send(String msg) {
            try {
                this.dos.writeUTF(msg);
                this.dos.flush();
            } catch (IOException e) {
                release();
            }
        }

        //接受消息
        private String receive() {
            String msg = null;
            try {
                msg = this.dis.readUTF();
            } catch (IOException e) {
                release();
            }
            return msg;
        }

        @Override
        public void run() {
            while(this.isRunning) {
                String msg = receive();
                System.out.println(msg);
                if (msg != null) {
                    String[] arr = msg.split("\\|");
                    if(arr[0].equals("close")) {
                        //如果已登录，就从map中移除
                        if(administrationMap.containsKey(arr[1])) {
                            administrationMap.remove(arr[1]);
                        }
                    } else if(arr[0].equals("getPath")) {
                        File file = new File("disk");
                        send("getPath|" + file.getAbsolutePath() + "/" + userId);
                    } else if(arr[0].equals("sendFile")) {
                        System.out.println(arr[1] + " " + arr[2]);
                        BufferedOutputStream bos = null;
                        try {
                            bos = new BufferedOutputStream(new FileOutputStream("disk/"+ userId + "/" + arr[2]));
                            byte[] bytes = new byte[1024 * 1024 * 10];
                            int len = -1;
                            while((len = dis.read(bytes)) != -1) {
                                bos.write(bytes, 0, len);
                                bos.flush();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            if(bos != null) {
                                try {
                                    bos.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        //弹出提示窗口
                        PromptWindowsController.showPromptWindows("上传成功");
                    }
                }
            }
        }

        //释放资源
        private void release() {
            System.out.println("一个客户端断开了连接");
            this.isRunning = false;
            try {
                if (this.client == null) {
                    this.client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (this.dis == null) {
                    this.dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (this.dos == null) {
                    this.dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
