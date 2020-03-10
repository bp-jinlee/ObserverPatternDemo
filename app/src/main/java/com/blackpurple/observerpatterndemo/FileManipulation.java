package com.blackpurple.observerpatterndemo;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class FileManipulation {

    private Context mContext;
    private String mFileDirectoryString;

    FileManipulation (Context context)
    {
        this.mContext = context;
    }
    //  Constructor with context, file directory name in sdcard.
    //  The device that you use must have sdcard.
    //  Exactly identical directory name with String parameter must be existed.
    //  Ex) If you want to use download directory in sdcard(/sdcard/Download),
    //  then the string must be "Download".
    FileManipulation (Context context, String fileDirectoryString)
    {
        this.mContext = context;
        this.mFileDirectoryString = fileDirectoryString;
    }

    //  Get file directory as file from directory name.
    public File getFileDirectory()
    {
        File fileDirectory;
        fileDirectory = Environment.getExternalStoragePublicDirectory(mFileDirectoryString);

        return fileDirectory;
    }

    //  Get files in your target directory as ArrayList.
    public ArrayList<File> getFilesInDirectory(File fileDirectory)
    {

        ArrayList<File> files = new ArrayList<>();
        for (File file : fileDirectory.listFiles())
        {
            files.add(file);
        }

        return files;
    }

    //  Change target file directory name.
    public void changeTargetDirectory(String fileDirectoryName)
    {
        this.mFileDirectoryString = fileDirectoryName;
    }

    //  Make directory according to string parameter.
    public void createFileDirectory(String directoryName)
    {
        //  Set file to create directory.
        File fileDirectory = new File(Environment.getExternalStorageDirectory() + File.separator + directoryName);
        //  Check if the directory is exists.
        if (!fileDirectory.exists() && !fileDirectory.isDirectory())
        {
            if (fileDirectory.mkdir())
            {
                Log.i("createFileDirectory", directoryName + " is created.");
            }
            else
            {
                Log.i("createFileDirectory", directoryName + " is not created.");
            }
        }
        else
        {
            Log.i("createFileDirectory", directoryName + " is already exists.");
        }
    }
}
