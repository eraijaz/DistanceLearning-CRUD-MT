class Alpha extends Thread
{
    public void run()   
    {
    String s=currentThread().getName();
    if (s.equals("bank"))
    {
        bank();
    }
    else if(s.equals("printing")) {
        printing();

    }
    else
    {
        calc();
      
    }
    }
   
    public void bank()   
    {
        synchronized(this)
        {
        
        try {
            Thread.sleep(200);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("banking activity");
        System.out.println("banking started");
        System.out.println("banking completed");
    }
    }
    public void printing()   
    {
        System.out.println("printing activity");
        try {
            Thread.sleep(200);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("printing commingsoon");
    }
    public void calc()   
    {
        System.out.println("calc activity");
        try {
            Thread.sleep(200);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("calccomming soon");

    }
}



public class  MtDemo1
{
    public static void main(String[] args)
     {
        System.out.println("hello main thread running");
        Alpha a1=new Alpha();
        Alpha a2=new Alpha();
        Alpha a3=new Alpha();
        a1.setName("bank");
        a2.setName("printing");
        a3.setName("calc");
        a1.start();
        a2.start();
        a3.start();

    }
}
    
