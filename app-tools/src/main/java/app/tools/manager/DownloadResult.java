package app.tools.manager;

public class DownloadResult {
    private Downloader downloader;
    private Object result;

    public void setDownloader(Downloader downloader) {
        this.downloader = downloader;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Downloader getDownloader() {
        return downloader;
    }

    public Object getResult() {
        return result;
    }
}
