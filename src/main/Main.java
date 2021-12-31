package main;

import downloader.Downloader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        String[] pages = new String[]{
                "https://phoenixnap.dl.sourceforge.net/project/reactos/ReactOS/0.4.14/ReactOS-0.4.14-iso.zip",
                "https://eur01.safelinks.protection.outlook.com/?url=https%3A%2F%2Fdownloads-global.3cx.com%2Fdownloads%2Fdebian10iso%2Fdebian-amd64-netinst-3cx.iso&data=04%7C01%7Calan.mejia%40atos.net%7C8ed21ee62bf24cbfa05708d9cbde7dfd%7C33440fc6b7c7412cbb730e70b0198d5a%7C0%7C0%7C637764978719150416%7CUnknown%7CTWFpbGZsb3d8eyJWIjoiMC4wLjAwMDAiLCJQIjoiV2luMzIiLCJBTiI6Ik1haWwiLCJXVCI6Mn0%3D%7C3000&sdata=nlaQzETWTBUvkxODDn8MnZGAdjZzk3XsnjXYZvZj38U%3D&reserved=0",
                "https://es.wikipedia.org/wiki/Rojo",
                "https://es.wikipedia.org/wiki/Azul",
                "https://es.wikipedia.org/wiki/P%C3%BArpura",
                "https://es.wikipedia.org/wiki/Verde"
        };
        ArrayList<Thread> threadArrayList = new ArrayList<>();
        for(int i=0;i<pages.length;i++){
            String page = pages[i];
            String[] singlePage = new String[1];
            singlePage[0] = page;
            Downloader newDownloader = new Downloader(singlePage);
            Thread newThread = new Thread(newDownloader);
            threadArrayList.add(newThread);
        }

        for(Thread thread : threadArrayList){
            thread.start();
        }

    }

}
