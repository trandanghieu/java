package graphic;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

 class Bai1 extends Frame implements ActionListener {
    Label lb1,lb2,lb3,lb;
    TextField txta,txtb,txtkq;
    Button tinh,reset,thoat;
    Panel pn,pn1,pn2,pn3;
    public void GUI(){
        lb=new Label("GIAI PT BAC NHAT");
        lb1=new Label("Input a :");
        lb2 =new Label("Input b :");
        lb3= new Label("Ket Qua :");
        txta= new TextField(7);
        txtb=new TextField(7);
        txtkq = new TextField();
        tinh = new Button("Tinh");
        reset = new Button("Reset");
        thoat = new Button("Thoat");

        tinh.addActionListener(this);
        reset.addActionListener(this);
        thoat.addActionListener(this);

        pn=new Panel(new GridLayout(3,1));
        pn1=new Panel(new FlowLayout());
        pn2=new Panel(new GridLayout(3,2));
        pn3= new Panel(new GridLayout(1,3));

        pn1.add(lb);

        pn2.add(lb1);
        pn2.add(txta);
        pn2.add(lb2);
        pn2.add(txtb);
        pn2.add(lb3);
        pn2.add(txtkq);

        pn3.add(tinh);
        pn3.add(reset);
        pn3.add(thoat);

        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        add(pn);
        setSize(400,300);

        show();


    }
    public Bai1(String a){
        super((a));
        GUI();
    }
     public void actionPerformed(ActionEvent e) {
         if(e.getSource()==tinh){
             int a=Integer.parseInt(txta.getText());
             int b= Integer.parseInt(txtb.getText());
             if(a ==0){
                 if(b==0){
                     txtkq.setText("PT Vo So Nghiem");
                 }else{
                     txtkq.setText("PT Vo Nghiem");
                 }
             }else{
                 txtkq.setText(Float.toString((float)-b/a));
             }
         }
         if(e.getSource()==reset){
             txtkq.setText("");
             txtb.setText("");
             txta.setText("");

         }
         if(e.getSource()==thoat){
             System.exit(0);
         }
     }
    public static void main(String[] args) {

        new Bai1("Giai PT Bac Nhat");
    }



 }