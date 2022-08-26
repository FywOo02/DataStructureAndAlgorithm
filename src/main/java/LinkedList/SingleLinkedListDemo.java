package LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode cho = new HeroNode(1, "cho");
        HeroNode owen = new HeroNode(2, "owen");
        HeroNode jason = new HeroNode(3, "Jason");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        /**
        singleLinkedList.addNode(owen);
        singleLinkedList.addNode(cho);
        singleLinkedList.addNode(jason);
        singleLinkedList.showList();
         */
        singleLinkedList.addNodeByOrder(owen);
        singleLinkedList.addNodeByOrder(cho);
        singleLinkedList.addNodeByOrder(jason);
        singleLinkedList.showList();
    }
}
class SingleLinkedList{
    // initial a head node
    private HeroNode head = new HeroNode(0,"");

    // add the node to list
    public void addNode(HeroNode heroNode){
        HeroNode temp = head;
        //iterate the list to the end
        while (true){
            if (temp.next == null){
                break;
            }
            // move back the temp if we do not find the end node
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addNodeByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag == true){
            System.out.println("cannot add this hero to list");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // show the list
    public void showList(){
        if (head.next == null){
            System.out.println("The list is empty");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int hNo, String hName){
        this.no = hNo;
        this.name = hName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
