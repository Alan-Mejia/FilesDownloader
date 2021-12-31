package observer;

public class DownloadPorcentage extends Observer{

    public DownloadPorcentage(Subject subject){
        this.subject = subject;
        this.subject.registerNewObserver(this);
    }

    @Override
    void update() {
        System.out.println(subject.getStatus());
    }
}
