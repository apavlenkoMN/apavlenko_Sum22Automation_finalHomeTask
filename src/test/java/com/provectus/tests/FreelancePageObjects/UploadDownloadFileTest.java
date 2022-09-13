package com.provectus.tests.FreelancePageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DownloadFilePage;
import pages.UploadFilePage;

import java.io.FileWriter;
import java.io.IOException;

public class UploadDownloadFileTest extends BaseTest {


    String theFileName = "";

//    Для скачивания - использовать страницу https://the-internet.herokuapp.com/download
//    Отсюда нужно скачать любой текстовый файл (при желании - можно усложнить, скачать рандомно любой из текстовых).
//    В этот файл записать несколько строк (содержимое строк - не важно)

    @Test (description = "download file", priority = 10)
    public void DownloadFile() throws InterruptedException, IOException {


        DownloadFilePage downloadFilePage = openApp().goToDownloadFilePage();

        Assert.assertEquals(downloadFilePage.getPageTitle(), "File Downloader", "compare title");

        String fileName = downloadFilePage.getFileName();
        theFileName = fileName;
        downloadFilePage.downloadTXTFile();

        FileWriter file = new FileWriter("/Users/apavlenko/Git/apavlenko_provectus_Sum22Automation_course/src/test/resources/testing/"+fileName, true);

        file.write("adding new text from the test2");
        file.write("\n");

        file.close();
        

        Assert.assertEquals(downloadFilePage.getPageTitle(), "File Downloader", "compare title");

    }

//    Для загрузки файла на сервер - использовать страницу https://the-internet.herokuapp.com/upload
//    проверить, что файл загружается


    @Test(description = "upload file", priority = 20)
    public void UploadFile(){

        UploadFilePage uploadFilePage = openApp().goToUploadFilePage();

        Assert.assertEquals(uploadFilePage.getPageTitle(), "File Uploader", "compare title");

      //  uploadFilePage.upload("src/test/resources/testing/testFile.csv").getAbsolutePath();

        uploadFilePage.upload("/Users/apavlenko/Git/apavlenko_provectus_Sum22Automation_course/src/test/resources/testing/" + theFileName);
        Assert.assertEquals(uploadFilePage.getPageTitle(), "File Uploaded!", "compare title after upload");


    }


}
