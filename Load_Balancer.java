import java.util.*;
class Server{
    private int serverId,capacity,currentLoad;
    Server(int serverId,int capacity){
        this.serverId=serverId;
        this.capacity=capacity;
        this.currentLoad=0;
    }void processRequest(int requestLoad){
        if (currentLoad+requestLoad<=capacity){
            currentLoad+=requestLoad;
            System.out.println("Request is handled by our Server "+serverId);
        }else{
            System.out.println("Server "+serverId+" is  full");
        }
    }int getLoad(){
        return currentLoad;
    }int getServerId() {
    return serverId;
}
}class WebServer extends Server{
    WebServer(int serverId,int capacity){
        super(serverId,capacity);
    }void processRequest(int requestLoad){
        System.out.println("this is Override function");
        System.out.println("Your Request is handled by our WebServer "+getServerId());
        super.processRequest(requestLoad);
    }
}class AppServer extends Server{
    AppServer(int serverId,int capacity){
        super(serverId,capacity);
    }void processRequest(int requestLoad){
        System.out.println("this is also Override function");
        System.out.println("your Request is handled by our AppServer "+getServerId());
        super.processRequest(requestLoad);
    }
}class Request{
    int requestId,load;
    Request(int requestId,int load){
        this.requestId=requestId;
        this.load=load;
    }Request(int requestId){
        this.requestId=requestId;
        this.load=0;
    }
}class LoadBalancer{
    ArrayList<Server> serverList;
    int index=0;
    LoadBalancer(){
        serverList=new ArrayList<>();
    }void addServer(Server server){
        serverList.add(server);
    }void addServer(Server[] servers){
        for(Server s:servers){
            serverList.add(s);
        }
    }void distributeRequest(Request request){
        if(serverList.size()==0){
            System.out.println("No servers avaiable");
            return;
        }Server s=serverList.get(index);
        s.processRequest(request.load);
        index++;
        if(index>=serverList.size()){
            index=0;
        }
    }void showServerLoad(){
        for(Server s:serverList){
            System.out.println("Server Id "+s.getServerId()+" Load "+s.getLoad());
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		LoadBalancer l=new LoadBalancer();
		Server s1 = new WebServer(1, 100);
        Server s2 = new AppServer(2, 150);
        Server s3 = new WebServer(3, 120);
        l.addServer(s1);
        Server[] arr = {s2, s3};
        l.addServer(arr);
		Request r1 = new Request(101, 30);
        Request r2 = new Request(102, 50);
        Request r3 = new Request(103, 70);
        Request r4 = new Request(104);
        l.distributeRequest(r1);
        l.distributeRequest(r2);
        l.distributeRequest(r3);
        l.distributeRequest(r4);
        l.showServerLoad();
	}
}
