import java.io.File;

public class FileWrapper{
    File file;
    public FileWrapper(File f){
        this.file = f;
    }
    public String toString()
    {
        return file.getName();
    }

    public File getFile(){
        return this.file;
    }

}