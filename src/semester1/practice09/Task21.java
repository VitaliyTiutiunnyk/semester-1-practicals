package semester1.practice09;

public class Task21 {
    public static void run(){
        DataCenterCluster cluster = new DataCenterCluster("Київ", 5);
        ServerNode server1 = new ServerNode("192.168.1.1", 16, 10, true);
        ServerNode server2 = new ServerNode("192.168.1.2", 32, 20, true);
        ServerNode server3 = new ServerNode("192.168.1.3", 8, 4, false);
        cluster.addNode(server1);
        cluster.addNode(server2);
        cluster.addNode(server3);
        System.out.println("=== ДО РОЗМІЩЕННЯ ===");
        System.out.println(cluster);
        System.out.println("Розміщення контейнера на 6 GB: " +
                cluster.deployContainer(6));
        System.out.println("Розміщення контейнера на 15 GB: " +
                cluster.deployContainer(15));
        System.out.println("Розміщення контейнера на 20 GB: " +
                cluster.deployContainer(20));
        System.out.println("\n=== ПІСЛЯ РОЗМІЩЕННЯ ===");
        System.out.println(cluster);
    }

    }

class ServerNode{
    private final String ipAddress;
    private final int totalRamGb;
    private int usedRamGb;
    private boolean online;
    ServerNode(String ipAddress, int totalRamGb, int usedRamGb, boolean online){
        this.ipAddress=ipAddress;
        this.totalRamGb=totalRamGb;
        this.usedRamGb=usedRamGb;
        this.online=online;
    }
    public int getFreeRamGb(){
        return totalRamGb-usedRamGb;
    }
    public boolean isOnline() {
        return online;
    }
    public void allocateRam(int ramGb) {
        usedRamGb += ramGb;
    }
    @Override
    public String toString() {
        return "IP-адрес: " + ipAddress +
                "\nОперативна пам'ять: " + usedRamGb + "/" + totalRamGb + " GB" +
                "\nВільна пам'ять: " + getFreeRamGb() + " GB" +
                "\nСтатус: " + (online ? "Онлайн" : "Офлайн");
    }
}
class  DataCenterCluster{
    private final String clusterLocation;
    private final ServerNode[] nodes;
    private int nodeCount;
    DataCenterCluster(String clusterLocation, int capacity){
        this.clusterLocation=clusterLocation;
        nodes=new ServerNode[capacity];
    }
    public void addNode(ServerNode node) {
        if (node != null && nodeCount < nodes.length) {
            nodes[nodeCount] = node;
            nodeCount++;
        }
    }
    public boolean deployContainer(int requiredRamGb) {
        for (int i = 0; i < nodeCount; i++) {
            if (nodes[i].isOnline() &&
                    nodes[i].getFreeRamGb() >= requiredRamGb) {
                nodes[i].allocateRam(requiredRamGb);
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String result = "=== КЛАСТЕР ДАТА-ЦЕНТРУ ===\n";
        result += "Розташування: " + clusterLocation + "\n";
        for (int i = 0; i < nodeCount; i++) {
            result += "\nСервер №" + (i + 1) + "\n";
            result += nodes[i].toString() + "\n";
        }
        return result;
    }
}
