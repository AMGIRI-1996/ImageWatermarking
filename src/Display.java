import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
/**
 * @author  Anurag
 * @created February 9, 2017
 */

public class Display extends JFrame {
	static Display theDisplay;
	String fPath;
	JPanel pnRoot;
	JSplitPane sppSplitPane6;
	
	JPanel pnLeft;
	JButton btNew_image;
	JButton btCheck_Image;
	JButton btInfo_Image;
	JButton btAdd_Image;
	
	JPanel pnRight;
	JLabel lbComments;
	
	JLabel pnImage_preview;
	JLabel lbHead;
	
	public static void main(String args[]) {
	   try {
	      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	   }
	   catch (ClassNotFoundException e) {
	   }
	   catch (InstantiationException e) {
	   }
	   catch (IllegalAccessException e) {
	   }
	   catch (UnsupportedLookAndFeelException e) {
	   }
	   theDisplay = new Display();
	}
	/*
	 * Function for GUI
	 */
	public Display() {
	   super("Watermarking");
	
	   pnRoot = new JPanel();
	   GridBagLayout gbRoot = new GridBagLayout();
	   GridBagConstraints gbcRoot = new GridBagConstraints();
	   pnRoot.setLayout(gbRoot);
	
	   sppSplitPane6 = new JSplitPane();
	   sppSplitPane6.setDividerLocation(159);
	   sppSplitPane6.setForeground(new Color(0,0,0));
	   sppSplitPane6.setLastDividerLocation(-1);
	
	   pnLeft = new JPanel();
	   GridBagLayout gbLeft = new GridBagLayout();
	   GridBagConstraints gbcLeft = new GridBagConstraints();
	   pnLeft.setLayout(gbLeft);
	
	   btNew_image = new JButton("New image");
	   gbcLeft.gridx = 0;
	   gbcLeft.gridy = 3;
	   gbcLeft.gridwidth = 8;
	   gbcLeft.gridheight = 3;
	   gbcLeft.fill = GridBagConstraints.BOTH;
	   gbcLeft.weightx = 1;
	   gbcLeft.weighty = 0;
	   gbcLeft.anchor = GridBagConstraints.NORTH;
	   gbLeft.setConstraints(btNew_image, gbcLeft);
	   pnLeft.add(btNew_image);
	
	   btCheck_Image = new JButton("Check Image");
	   gbcLeft.gridx = 0;
	   gbcLeft.gridy = 9;
	   gbcLeft.gridwidth = 8;
	   gbcLeft.gridheight = 3;
	   gbcLeft.fill = GridBagConstraints.BOTH;
	   gbcLeft.weightx = 1;
	   gbcLeft.weighty = 0;
	   gbcLeft.anchor = GridBagConstraints.NORTH;
	   gbLeft.setConstraints(btCheck_Image, gbcLeft);
	   pnLeft.add(btCheck_Image);
	 
	   btInfo_Image = new JButton("Information Image");
	   gbcLeft.gridx = 0;
	   gbcLeft.gridy = 15;
	   gbcLeft.gridwidth = 8;
	   gbcLeft.gridheight = 3;
	   gbcLeft.fill = GridBagConstraints.BOTH;
	   gbcLeft.weightx = 1;
	   gbcLeft.weighty = 0;
	   gbcLeft.anchor = GridBagConstraints.NORTH;
	   gbLeft.setConstraints(btInfo_Image, gbcLeft);
	   pnLeft.add(btInfo_Image);
	 
	 
	   btAdd_Image = new JButton("Add Image");
	   gbcLeft.gridx = 0;
	   gbcLeft.gridy = 21;
	   gbcLeft.gridwidth = 8;
	   gbcLeft.gridheight = 3;
	   gbcLeft.fill = GridBagConstraints.BOTH;
	   gbcLeft.weightx = 1;
	   gbcLeft.weighty = 0;
	   gbcLeft.anchor = GridBagConstraints.NORTH;
	   gbLeft.setConstraints(btAdd_Image, gbcLeft);
	   pnLeft.add(btAdd_Image);
	   sppSplitPane6.setLeftComponent(pnLeft);
	
	   pnRight = new JPanel();
	   GridBagLayout gbRight = new GridBagLayout();
	   GridBagConstraints gbcRight = new GridBagConstraints();
	   pnRight.setLayout(gbRight);
	
	   lbComments = new JLabel("This is comment");
	   lbComments.setBounds(0, 400, 100, 100);
	 
	   Border border;
	   pnRight.add(lbComments);
	
	   pnImage_preview = new JLabel();
	   GridBagLayout gbImage_preview = new GridBagLayout();
	   GridBagConstraints gbcImage_preview = new GridBagConstraints();
	   pnImage_preview.setLayout(gbImage_preview);
	   gbcRight.gridx = 0;
	   gbcRight.gridy = 0;
	   gbcRight.gridwidth = 10;
	   gbcRight.gridheight = 13;
	   gbcRight.fill = GridBagConstraints.BOTH;
	   gbcRight.weightx = 1;
	   gbcRight.weighty = 0;
	   gbcRight.anchor = GridBagConstraints.NORTH;
	   gbRight.setConstraints(pnImage_preview, gbcRight);
	   pnRight.add(pnImage_preview);
	   sppSplitPane6.setRightComponent(pnRight);
	   gbcRoot.gridx = 0;
	   gbcRoot.gridy = 3;
	   gbcRoot.gridwidth = 20;
	   gbcRoot.gridheight = 17;
	   gbcRoot.fill = GridBagConstraints.BOTH;
	   gbcRoot.weightx = 1;
	   gbcRoot.weighty = 1;
	   gbcRoot.anchor = GridBagConstraints.NORTH;
	   gbcRoot.insets = new Insets(20,20,20,20);
	   gbRoot.setConstraints(sppSplitPane6, gbcRoot);
	   pnRoot.add(sppSplitPane6);
	
	   lbHead = new JLabel("Watermarking project");
	   lbHead.setSize(getPreferredSize());
	   pnRoot.add(lbHead);
	
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	   setContentPane(pnRoot);
	   pack();
	   setVisible(true);
	   JFrame t;
	   setSize(1000, 1000);
	 
	   btNew_image.addActionListener(new browse());
	   btInfo_Image.addActionListener(new browse());
	   btAdd_Image.addActionListener(new browse());
	}

	/*
	 * GUI Listeners
	 */
	public class browse implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // TODO Auto-generated method stub
	        if (e.getSource() == btNew_image) {
	        	//New Image to be saved in codebook
	        	
	        	//Get it from file
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setFileFilter(imageFilter);
	            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	            
	            int result = fileChooser.showOpenDialog(Display.this);
	            if (result == JFileChooser.APPROVE_OPTION) {	            	
	            	
	                File selectedFile = fileChooser.getSelectedFile();
	                fPath=selectedFile.getAbsolutePath();
	                System.out.println("Selected file: " + fPath);
	                lbComments.setText(fPath);
	                BufferedImage myPicture;
	                try {
	                    myPicture = ImageIO.read(new File(fPath));
	                    pnImage_preview.setIcon(new ImageIcon(fPath));
	                    
	                    //Process it to convert in robust and save in codebook
	                    process(myPicture);
	                  
	                } catch (IOException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	              
	            }
	        }else if (e.getSource() == btInfo_Image) {
	        	//Information Image
	        	
	        	//Get it from files
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setFileFilter(imageFilter);
	            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	            
	            int result = fileChooser.showOpenDialog(Display.this);
	            if (result == JFileChooser.APPROVE_OPTION) {
	                File selectedFile = fileChooser.getSelectedFile();
	                fPath=selectedFile.getAbsolutePath();
	                System.out.println("Selected file: " + fPath);
	                lbComments.setText(fPath);
	                BufferedImage myPicture;
	                try {
	                    myPicture = ImageIO.read(new File(fPath));
	                    pnImage_preview.setIcon(new ImageIcon(fPath));
	                    
	                    //process it by transforming
	                    process2(myPicture);
	                  
	                } catch (IOException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	              
	            }
	        }else if (e.getSource() == btAdd_Image) {
	            //
	        }
	    }
	
	
	/*
	 * For taking only images from the pc
	 */
	FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
	
	/*
	 * Image and information image arrays
	 */
	int N=64;
	int [] image1d = new int[N*N];
	int[][] image2d = new int[N][N];
	
	int [] infoImage1d = new int[N*N];
	int[][] infoImage2d = new int[N][N];
	BufferedImage BinfoImage,Bimage;
	
	//for use in add zeros
	public  String replaceCharAt(String s, int pos, char c) {
	   return s.substring(0,pos) + c + s.substring(pos+1);
	}
	//for use in make robust adds zeros to make length atleast 8
	public  String addZeros(String s) {
	    int l=s.length();
	    String r="";
	    for(int i=0;i<8-l;i++)
	     r+="0";
	   return r+s;
	}
	/*
	 * Function to make self recovery image
	 */
	public void makeRobust(){
		/*
		 * Taking one block as 4*4 pixel
		 * Blocks are considered and numbered row wise
		 */
	    int s=N/4;
	    
        for(int i=0;i<s;i++){
            for(int j=0;j<s;j++){
            	//operating on blocks
            	
            	//leaves first block 
                if(i==0&&j==0) continue;
                int avg_b=0;
                for(int k=0;k<4;k++){
                    for(int l=0;l<4;l++){
                        avg_b+=image2d[i*4+k][j*4+l];
                    }
                }
                avg_b/=16;
                //setting p as parity of first six bits of average of block(avg_b)
                String binaryString = Integer.toBinaryString(avg_b);
                if(binaryString.length()<8) binaryString= addZeros(binaryString);
                binaryString = binaryString.substring(binaryString.length() - 8);
                int pc=0;
                for(int z=0;z<6;z++) if(binaryString.charAt(z)=='1')pc++;
                char p=(pc%2==0) ?'0':'1';
                
                //pj, pi stores index of previous block(a)
                int pj=j-1,pi=i;
                if(pj==-1){pj=s-1;pi=i-1;}
               
              //dividing block into 2*2 block
                for(int k=0;k<2;k++){
                    for(int l=0;l<2;l++){
                    	
                        int avg_bs=0,avg_as=0;
                        for(int m=0;m<2;m++){
                            for(int n=0;n<2;n++){
                                avg_bs+=image2d[i*4+k*2+m][j*4+l*2+n];
                                avg_as+=image2d[pi*4+k*2+m][pj*4+l*2+n];
                            }
                        }
                        /*
                         * embedding first six bits of as into bs---> r1-r6
                         * and p(calculated earlier)
                         * v= 1 if(avg_bs>=avg_b) 
                         * avg_b-> avg of whole block
                         * avg_bs-> avg of sub block
                         *  ________
                         * |   |    |
                         * | 1 |  2 |
                         * |--------|
                         * | 3 |  4 |   
                         * |___|____|  
                         * 
                         * last 2 bits of b1,b2,b3,b4 are changed
                         * pixel --- last 2 bits
                         * b1    v,r3
                         * b2    p,r4
                         * b3    r1,r5
                         * b4    r2,r6
                         */
                        avg_bs/=4;avg_as/=4;
                        char v = (avg_bs>=avg_b) ? '1': '0';
                        String binaryStringR = Integer.toBinaryString(avg_as);
                        if(binaryStringR.length()<8) binaryStringR= addZeros(binaryStringR);
               
                        binaryStringR = binaryString.substring(binaryStringR.length() - 8);
                        char r1=binaryStringR.charAt(0),r2=binaryStringR.charAt(1),r3=binaryStringR.charAt(2),r4=binaryStringR.charAt(3),r5=binaryStringR.charAt(4),r6=binaryStringR.charAt(5);
                        String bs,zz;
                        bs=Integer.toBinaryString(image2d[i*4+k*2+0][j*4+l*2+0]);
                        zz=bs;
                        if(bs.length()<8) bs= addZeros(bs);
               
                        bs=bs.substring(bs.length() - 8);
                        bs=replaceCharAt(bs,6,v);
                        bs=replaceCharAt(bs,7,r3);
                        System.out.println(zz+"->"+bs);
                        image2d[i*4+k*2+0][j*4+l*2+0]= Integer.parseInt(bs, 2);
                       
                        bs=Integer.toBinaryString(image2d[i*4+k*2+0][j*4+l*2+1]);
                        zz=bs;
                        if(bs.length()<8) bs= addZeros(bs);
               
                        bs=bs.substring(bs.length() - 8);
                        bs=replaceCharAt(bs,6,p);
                        bs=replaceCharAt(bs,7,r4);
                        System.out.println(zz+"->"+bs);
                        image2d[i*4+k*2+0][j*4+l*2+1]= Integer.parseInt(bs, 2);
                       
                        bs=Integer.toBinaryString(image2d[i*4+k*2+1][j*4+l*2+0]);
                        zz=bs;
                        if(bs.length()<8) bs= addZeros(bs);
               
                        bs=bs.substring(bs.length() - 8);
                        bs=replaceCharAt(bs,6,r1);
                        bs=replaceCharAt(bs,7,r5);
                        System.out.println(zz+"->"+bs);
                        image2d[i*4+k*2+1][j*4+l*2+0]= Integer.parseInt(bs, 2);
                       
                        bs=Integer.toBinaryString(image2d[i*4+k*2+1][j*4+l*2+1]);
                        zz=bs;
                        if(bs.length()<8) bs= addZeros(bs);
               
                        System.out.println(zz+" "+bs.length()+" "+image2d[i*4+k*2+1][j*4+l*2+1]);
                        bs=bs.substring(bs.length() - 8);
                        bs=replaceCharAt(bs,6,r2);
                        bs=replaceCharAt(bs,7,r6);
                        System.out.println(zz+"->"+bs);
                        image2d[i*4+k*2+1][j*4+l*2+1]= Integer.parseInt(bs, 2);
                       
               
                    }
                }
            }
        }
	}
	
	void transform(){
	    int k=37;
	   /*
	    * Information image is been transformed into new matrix
	    * [x']       [x]
	    * [  ] = A * [ ]
	    * [y']       [y]
	    *  
	    *   [ 1   1  ]
	    * A=[ k   k+1]
	    * 
	    * k is declared above it can be changed
	    */
	    int [][] infoImage2d2 = new int[N][N];
	System.out.println(" Before:");
	
	    for(int i=0;i<N;i++){
	    	for(int j=0;j<N;j++){
		        infoImage2d2[(k*(i+j))%N][(k*(i+j)+j)%N]=infoImage2d[i][j];
		        System.out.print(infoImage2d[i][j]+" ");
	    	}  
	    	System.out.println("\n");
	    }
	    System.out.println("\nAfter Transformed:");
	
	    for(int i=0;i<N;i++){
	    	for(int j=0;j<N;j++){
	    		infoImage2d[i][j]=infoImage2d2[i][j];
	        System.out.print(infoImage2d[i][j]+" ");
	    	}
	    	System.out.println("\n");
	    }
	    System.out.println();
	}
	
	/*
	 * To resize the image
	 */
	public  BufferedImage resize(BufferedImage inputImage, int scaledWidth, int scaledHeight)
	        throws IOException {
	    
	    BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());
	
	    
	    Graphics2D g2d = outputImage.createGraphics();
	    g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	    g2d.dispose();
	
	    return outputImage;
	}
	
	/*
     * Function to convert image in 2D
     */
    private int[][] convertTo2DUsingGetRGB(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] result = new int[height][width];
      
        int ww=width/N;
        int hw=height/N;
      
        for(int i=0; i<height; i++){
           
            for(int j=0; j<width; j++){
          
               Color c = new Color(image.getRGB(j, i));
               int red = (int)(c.getRed() );
               int green = (int)(c.getGreen());
               int blue = (int)(c.getBlue());
               //Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
               //result[i][j]=image.getRGB(j, i);
               result[i][j]=red;
               //image.setRGB(j,i,red);
               System.out.print(red+" ");
            }
            System.out.print("\n");
          
         }
        return result;
     }
        
	    /*
	     * Process on new image
	     */
	    public void process(BufferedImage img){
	      
	        try {
	            Bimage = resize(img, N, N);
	            image2d = convertTo2DUsingGetRGB(Bimage);
	            makeRobust();
	            int ind=0;
	            for(int i=0;i<N;i++){
	                for(int j=0;j<N;j++){
	                    System.out.print(image2d[i][j]+" ");
	                    image1d[ind++]=image2d[i][j];
	                }
	                System.out.println("\n\n");
	            }
	          
	            Bimage = new BufferedImage(N,N, BufferedImage.TYPE_INT_RGB);
	            Bimage.setRGB(0, 0, N, N, image1d, 0, N);
	            pnImage_preview.setIcon(new ImageIcon(Bimage));
	            File outputfile = new File("image.jpg");
	            try {
	                ImageIO.write(Bimage, "jpg", outputfile);
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	    }
	  
	public void process2(BufferedImage img){
	      
	        try {
	            BinfoImage = resize(img, N, N);
	            infoImage2d = convertTo2DUsingGetRGB(BinfoImage);
	            transform();
	            int ind=0;
	            for(int i=0;i<N;i++){
	                for(int j=0;j<N;j++){
	                    System.out.print(infoImage2d[i][j]+" ");
	                    infoImage1d[ind++]=infoImage2d[i][j];
	               }
	                System.out.println("\n\n");
	            }
	           
	            BinfoImage = new BufferedImage(N,N, BufferedImage.TYPE_INT_RGB);
	            BinfoImage.setRGB(0, 0, N, N, infoImage1d, 0, N);
	            pnImage_preview.setIcon(new ImageIcon(BinfoImage));
	            File outputfile = new File("image.jpg");
	            try {
	                ImageIO.write(BinfoImage, "jpg", outputfile);
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	    }
	  
	}


}

