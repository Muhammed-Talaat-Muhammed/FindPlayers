package eg.edu.alexu.csd.datastructure.iceHockey.cs66;

import java.awt.Point;

public class PlayersFinder implements IPlayersFinder{
private static int i1=0;
private static int i2=0;
private static boolean flag;
public static int[][] spar=null;
private int q=0;
private Point[] Par;
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		if((photo.length<1)||(photo[0].length()==0)) {throw new NullPointerException("EMPTY IMG");}
		Par=new Point[2500];
    	for(int i=0;i<2500;i++) {Par[i]=new Point(-1,-1);}
        char [][]photo0=new char[photo.length][photo[0].length()];int z=0;boolean Flag=true;
		int [][] spar=new int[photo.length+2][photo[0].length()+2];
		for(int i=0;i<photo.length+2;i++) {
			for(int j=0;j<photo[0].length()+2;j++) {spar[i][j]=0;}
		}
		for(int i=0;i<photo.length;i++) {z=0;
			for(int j=0;j<photo[0].length();j++) {
				photo0[i][j]=photo[i].charAt(z++);
				if(Character.getNumericValue(photo0[i][j])==team) {spar[i+1][j+1]=1;}
			}
		}
		while(Flag) {
			Flag=false;
			for(int i=1;i<photo.length+1;i++) {
				for(int j=1;j<photo[0].length()+1;j++) {if(spar[i][j]!=0) {Flag=true;break;};}
			}
			if(!Flag) {break;}
			if(Flag) {
			for(int i=1;i<photo.length+1;i++) {
				for(int j=1;j<photo[0].length()+1;j++) {if(spar[i][j]!=0) {
					flag = true;i2=0;i1=0;
					spar[i][j]=15;i2++;
				    int xmin=0;int xmax=0;int ymin=0; int ymax=0;
					while(flag) {flag=false;
					if(i1%2==0) {
					for(int v=i;v<spar.length-1;v++) {
						for(int t=1;t<spar[0].length-1;t++) {
						if((spar[v][t]==1)&&(spar[v][t-1]==15)){spar[v][t]=15;i2++;flag=true;}
						else if((spar[v][t]==1)&&(spar[v-1][t]==15)) {spar[v][t]=15;i2++;flag=true;}
						else if((spar[v][t]==1)&&(spar[v+1][t]==15)) {spar[v][t]=15;i2++;flag=true;}
						else if((spar[v][t]==1)&&(spar[v][t+1]==15)) {spar[v][t]=15;i2++;flag=true;}}}i1++;}
					if(i1%2==1) {
						for(int v=spar.length-2;v>=i;v--) {
							for(int t=1;t<spar[0].length-1;t++) {
							if((spar[v][t]==1)&&(spar[v][t-1]==15)){spar[v][t]=15;i2++;flag=true;}
							else if((spar[v][t]==1)&&(spar[v-1][t]==15)) {spar[v][t]=15;i2++;flag=true;}
							else if((spar[v][t]==1)&&(spar[v+1][t]==15)) {spar[v][t]=15;i2++;flag=true;}
							else if((spar[v][t]==1)&&(spar[v][t+1]==15)) {spar[v][t]=15;i2++;flag=true;}}}i1++;}}
					if((4*i2)>=threshold) {xmin=j-1;xmax=j-1;ymin=i-1;ymax=i-1;
						for(int v=0;v<spar.length-2;v++) {
							for(int t=0;t<spar[0].length-2;t++) {if(spar[v+1][t+1]==15) {spar[v+1][t+1]=0;
								if(v>ymax) {ymax=v;};
								if(v<ymin) {ymin=v;};
								if(t>xmax) {xmax=t;};
								if(t<xmin) {xmin=t;};}}}
						Par[q++]=new Point(xmax+xmin+1,ymin+ymax+1);
						}
					else if((4*i2)<threshold) {
						for(int v=1;v<spar.length-1;v++) {
						for(int t=1;t<spar[0].length-1;t++) {if(spar[v][t]==15) {spar[v][t]=0;}
				}}};}}}}}
		
		int o=0;int tt=0;
		for(int i=0;i<Par.length;i++) {if((Par[i].x>-1)||(Par[i].y>-1)) {o++;}}
		Point [] Para = new Point[o];
		for(int i=0;i<Par.length;i++) {if((Par[i].x>-1)||(Par[i].y>-1)) {Para[tt++]=Par[i];}}
		return Para;
	}}