package zk.demo;

import com.alibaba.dubbo.remoting.zookeeper.ZookeeperClient;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.proto.WatcherEvent;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.Watcher.Event.EventType.NodeDataChanged;

/**
 * Create by  ASUS on 2019/9/17.
 * description:
 */
public class ZkBase {
    
    @Test
    public void testWatch() throws Exception {
        final ZooKeeper zk = new ZooKeeper("192.168.0.108:2181", 5000, null);
        Stat st = new Stat();
        //回调
        Watcher w = new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                try {
                    System.out.println("修改了！！");
                    zk.getData("/hello", this, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        
        byte[] data = zk.getData("/hello", w, st);
        System.out.println(new String(data));
        //观察效果，线程睡眠
        while (true) {
            Thread.sleep(1000);
        }
    }
    
    /**
     * zookeeper地址
     */
    static final String CONNECT_ADDR = "192.168.0.108:2181";
    /**
     * session超时时间
     */
    static final int SESSION_OUTTIME = 2000;// ms
    /**
     * 信号量，阻塞程序执行，用于等待zookeeper连接成功，发送成功信号
     */
    static final CountDownLatch connectedSemaphore = new CountDownLatch(1);
    
    public static void main(String[] args) throws Exception {
        
        ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new ZKWatch());
        
        // 进行阻塞
//        connectedSemaphore.await();
        
        System.out.println("..");
        // 创建父节点
//         zk.create("/testRoot", "testRoot".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
//         CreateMode.PERSISTENT);

//         创建子节点
//         zk.create("/testRoot/children", "children data".getBytes(),
//         ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        
        // 获取节点洗信息
//         byte[] data = zk.getData("/testRoot", false, null);
//         System.out.println(new String(data));
//         System.out.println(zk.getChildren("/testRoot", false));
        
        // 修改节点的值
//        zk.setData("/testRoot", "modify data root".getBytes(), - 1);
//        byte[] data = zk.getData("/testRoot", new ZKWatch(), null);
        zk.exists("/haizeiwang",new ZKWatch());
        List<String> children = zk.getChildren("/hello", new ZKWatch());
        System.out.println(children);
////        System.out.println(new String(data));
//        zk.exists("")
//        // 判断节点是否存在
//        System.out.println(zk.exists("/testRoot/children", new ZKWatch()));
//        // 删除节点
////        zk.delete("/testRoot/children", - 1);
//        System.out.println(zk.exists("/testRoot/children", new ZKWatch()));
        
        
        while(true){
            Thread.sleep(100);
        }
        
        
    }
    
    
}

class ZKWatch implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        Event.KeeperState state = watchedEvent.getState();
        Event.EventType type = watchedEvent.getType();
        WatcherEvent wrapper = watchedEvent.getWrapper();
        String path = watchedEvent.getPath();
        //连接情况监听
        switch (state) {
            case SyncConnected:
                System.out.println("连接建立====>>");
                
                break;
            case Disconnected:
                System.out.println("连接断开===>>>>");
                break;
            case AuthFailed:
                System.out.println("认证失败====>>>>");
                break;
            case ConnectedReadOnly:
                System.out.println("只读节点====>>>");
                break;
            default:
                System.out.println("未知事件=====>>>");
                break;
            
        }
        
        switch (type) {
            case NodeCreated:
                System.out.println("节点船舰====>>>>>");
                break;
            case NodeDeleted:
                System.out.println("节点删除=====>>>>");
                break;
            case NodeChildrenChanged:
                System.out.println("子节点修改=====>>>>");
                break;
            case NodeDataChanged:
                System.out.println("节点数据改变=======>>>>>");
                break;
            default:
                System.out.println("未知事件");
        }
        
        
    }
}
