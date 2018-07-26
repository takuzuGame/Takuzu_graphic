package sample.puzzle;

public class setPuzzle {
    public int size;
    public int [][] tab;

    public static setPuzzle intialPuzzle(init4 m,setPuzzle p){
        p = emptyPuzzle(p);
        int t =(int)(Math.random() * 2);
        if(t==0) {
            p=remplirPoss(m.poss1,p);
        }
        if(t==1) {
            p=remplirPoss(m.poss2,p);
        }
        return(p);
    }

    private static setPuzzle remplirPoss(int[][] poss1, setPuzzle p) {
        int a=0;
        int []t= {0,0,0,0};
        do {
            int u =(int)(Math.random() * p.size);
            int v =(int)(Math.random() * p.size);
            if(t[v]==0) {
                if(nonVideLigne(u,p)==0) {
                    t[v]=1;
                    for (int j=0;j<p.size;j++) {
                        p.tab[u][j] = poss1[v][j];
                    }
                    a++;
                }
            }
        }while(a<p.size);
        return(p);
    }

    private static int nonVideLigne(int u, setPuzzle p) {
        for(int j=0;j<p.size;j++) {
            if(p.tab[u][j]!=-1)
                return(u+1);
        }
        return(0);
    }

    private static setPuzzle emptyPuzzle(setPuzzle p) {

        for (int i = 0; i <p.size ; i++) {
            for (int j = 0; j <p.size ; j++)
                p.tab[i][j] = -1;

    }
    return p;
    }


    public static setPuzzle emptycel(setPuzzle p){
        setPuzzle f;
        f = Initialize(p.size);
        for(int i=0;i<p.size;i++) {
            for(int j=0;j<p.size;j++) {
                f.tab[i][j]=p.tab[i][j];
            }
        }
        int [][] table=new int[p.size][p.size];
        for(int i=0;i<p.size;i++) {
            for(int j=0;j<p.size;j++) {
                table[i][j]=0;
            }
        }
        do {
            int i=(int)(Math.random() * p.size);
            int j=(int)(Math.random() * p.size);
            int a=f.tab[i][j];
            table[i][j]=1;
            f.tab[i][j]=-1;

            if(nbSol4(f)!=1 && f.size==4 || nbSol6(f)!=1 && (f.size==6 || f.size==8)) {
                f.tab[i][j] = a;
            }
        }while(complet(table,p.size)==0);
        return(f);
    }

      public static int nbSol6(setPuzzle p) {
        int t=0,g=0;
        setPuzzle f=Initialize(p.size);
        for(int i=0;i<p.size;i++) {
            for(int j=0;j<p.size;j++) {
                f.tab[i][j]=p.tab[i][j];
            }
        }
        //difficile
		/*
		for(int i=0;i<f.n;i++) {
			int n0=0;
			int n1=1;
			for(int j=0;j<f.n;j++) {
				if(f.tab[i][j].val==0)
					n0++;
				if(f.tab[i][j].val==1)
					n1++;
			}
			if(n0==f.n/2) {
			for(int j=0;j<f.n;j++) {
				if(f.tab[i][j].val!=0)
					f.tab[i][j].val=1;
			}
			}
			if(n1==f.n/2) {
				for(int j=0;j<f.n;j++) {
					if(f.tab[i][j].val!=1)
						f.tab[i][j].val=0;
				}
				}
		}
		for(int j=0;j<f.n;j++) {
			int n0=0;
			int n1=1;
			for(int i=0;i<f.n;i++) {
				if(f.tab[i][j].val==0)
					n0++;
				if(f.tab[i][j].val==1)
					n1++;
			}
			if(n0==f.n/2) {
			for(int i=0;i<f.n;i++) {
				if(f.tab[i][j].val!=0)
					f.tab[i][j].val=1;
			}
			}
			if(n1==f.n/2) {
				for(int i=0;i<f.n;i++) {
					if(f.tab[i][j].val!=1)
						f.tab[i][j].val=0;
				}
				}
		}*/
        //fin difficile

        do{
            // pour 6*6
            for(int i=0;i<f.size;i++) {
                for(int j=0;j<f.size-2;j++) {
                    if(test(f.tab[i][j],f.tab[i][j+2])==1) {
                        f.tab[i][j+1]=1-f.tab[i][j];
                    }
                }
            }
            for(int i=0;i<f.size-2;i++) {
                for(int j=0;j<f.size;j++) {
                    if(test(f.tab[i][j],f.tab[i+2][j])==1) {
                        f.tab[i+1][j]=1-f.tab[i][j];
                    }
                }
            }
            for(int i=0;i<f.size-2;i++) {
                for(int j=0;j<f.size;j++) {
                    if(test(f.tab[i][j],f.tab[i+1][j])==1) {
                        if(i<f.size-2)
                            f.tab[i+2][j]=1-f.tab[i][j];
                        if(i>0)
                            f.tab[i-1][j]=1-f.tab[i][j];

                    }
                }
            }
            for(int i=0;i<f.size;i++) {
                for(int j=0;j<f.size-1;j++) {
                    if(test(f.tab[i][j],f.tab[i][j+1])==1) {
                        if(j<f.size-2)
                            f.tab[i][j+2]=1-f.tab[i][j];
                        if(j>0)
                            f.tab[i][j-1]=1-f.tab[i][j];
                    }
                }
            }

            //jusqu'à ici
         t++;
        }while(t<15);
        for(int i=0;i<f.size;i++) {
            for(int j=0;j<f.size;j++) {
                if(f.tab[i][j]==-1)
                    return(0);
            }
        }
        return(1);
    }

    private static int nbSol4(setPuzzle p) {
        int t=0;
        setPuzzle f = Initialize(p.size);
        for(int i=0;i<p.size;i++) {
            for(int j=0;j<p.size;j++) {
                f.tab[i][j]=p.tab[i][j];
            }
        }
        do{
            for(int i=0;i<f.size;i++) {
                if(test(f.tab[i][0],f.tab[i][2])==1) {
                    f.tab[i][1]=1-f.tab[i][0];
                    f.tab[i][3]=1-f.tab[i][0];
                }
                if(test(f.tab[i][0],f.tab[i][3])==1) {
                    f.tab[i][1]=1-f.tab[i][0];
                    f.tab[i][2]=1-f.tab[i][0];
                }
                if(test(f.tab[i][0],f.tab[i][1])==1) {
                    f.tab[i][3]=1-f.tab[i][0];
                    f.tab[i][2]=1-f.tab[i][0];
                }
                if(test(f.tab[i][1],f.tab[i][2])==1) {
                    f.tab[i][0]=1-f.tab[i][1];
                    f.tab[i][3]=1-f.tab[i][1];
                }
                if(test(f.tab[i][1],f.tab[i][3] )== 1) {
                    f.tab[i][0]=1-f.tab[i][1];
                    f.tab[i][2]=1-f.tab[i][1];
                }
                if(test(f.tab[i][2],f.tab[i][3])==1) {
                    f.tab[i][1]=1-f.tab[i][2];
                    f.tab[i][0]=1-f.tab[i][2];
                }
            }
            for(int i=0;i<f.size;i++) {
                if(test(f.tab[0][i],f.tab[2][i])==1) {
                    f.tab[1][i]=1-f.tab[0][i];
                    f.tab[3][i]=1-f.tab[0][i];
                }
                if(test(f.tab[0][i],f.tab[3][i])==1) {
                    f.tab[1][i]=1-f.tab[0][i];
                    f.tab[2][i]=1-f.tab[0][i];
                }
                if(test(f.tab[0][i],f.tab[1][i])==1) {
                    f.tab[3][i]=1-f.tab[0][i];
                    f.tab[2][i]=1-f.tab[0][i];
                }
                if(test(f.tab[1][i],f.tab[2][i])==1) {
                    f.tab[0][i]=1-f.tab[1][i];
                    f.tab[3][i]=1-f.tab[1][i];
                }
                if(test(f.tab[1][i],f.tab[3][i])==1) {
                    f.tab[0][i]=1-f.tab[1][i];
                    f.tab[2][i]=1-f.tab[1][i];
                }
                if(test(f.tab[2][i],f.tab[3][i])==1) {
                    f.tab[1][i]=1-f.tab[2][i];
                    f.tab[0][i]=1-f.tab[2][i];
                }
            }
            t++;
        }while(t<15);
        for(int i=0;i<f.size;i++) {
            for(int j=0;j<f.size;j++) {
                if(f.tab[i][j]==-1)
                    return(0);
            }
        }
        return(1);
    }

    private static int test(int a, int b)
    {
        if ((a==b)&&(a==0)||(a==b)&&(a==1))
            return(1);
        else
            return(0);
    }

    private static int complet(int[][] t, int s) {
        for(int i=0;i<s;i++) {
            for(int j=0;j<s;j++) {
                if(t[i][j]==0)
                    return(0);
            }
    }
    return 1 ;
}
    public static setPuzzle Initialize(int size){
        setPuzzle p = new setPuzzle();
        p.size = size;
        int [][] tab = new int[p.size][p.size];
        for(int i=0;i<p.size;i++) {
            for(int j=0;j<p.size;j++) {
                tab[i][j]=(int)(Math.random() * 2);
            }
        }
        p.tab=tab;
        return(p);

    }

    public static void printPuzzle(setPuzzle p){
        for (int i = 0; i <p.size ; i++) {
            for (int j = 0; j <p.size; j++) {
                System.out.print(p.tab[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static setPuzzle intialPuzzle6(init6 m, setPuzzle p) {
        int [] t=new int[14];
        int u;
        for(int i=0;i<14;i++) {
            t[i]=0;
        }
        u =(int)(Math.random() * 14);
        p=remplirLigne(p,0,m.poss[u]);
        t[u]=1;
        if(u%2==0) {
            p=remplirLigne(p,1,m.poss[u+1]);
            t[u+1]=1;
        }
        else {
            p=remplirLigne(p,1,m.poss[u-1]);
            t[u-1]=1;
        }
        for(int i=1;i<p.size;i++) {
            if(i%2==0) {
                do
                    u =(int)(Math.random() * 14);
                while(t[u]==1);
                if(t[u]==0 && verifCond(p,i,m.poss[u])==1) {
                    t[u]=1;
                    p=remplirLigne(p,i,m.poss[u]);
                    if(u%2==0) {
                        p=remplirLigne(p,i+1,m.poss[u+1]);
                        t[u+1]=1;
                    }
                    else {
                        p=remplirLigne(p,i+1,m.poss[u-1]);
                        t[u-1]=1;
                    }
                }
                else {
                    i--;
                }
            }
        }
        return(p);
    }

    private static int verifCond(setPuzzle p, int i, int[] t) {

        for(int v=0;v<p.size;v++) {//calcule du nombre de 0 et nbre de 1 dans les case presedentes de la meme colonne
            int nb0=0;
            if(t[v]==0)
                nb0++;
            int nb1=t[v];
            for(int k=0;k<i;k++) {
                nb1+=p.tab[k][v];
                if(p.tab[k][v]==0) {
                    nb0++;
                }
            }
            if(t[v]==p.tab[i-1][v] && t[v]==p.tab[i-2][v] || nb0>p.size/2 || nb1>p.size/2)
                //System.out.println(nb1+"   "+nb0);
                return(0);
        }
        return(1);
    }

    private static setPuzzle remplirLigne(setPuzzle p, int i, int[] l) {
        for(int j=0;j<p.size;j++) {
            p.tab[i][j]=l[j];
        }
        return(p);
    }


    public static void main(String[]args){
        init8 m8 = new init8();
        setPuzzle f, p;

        p = Initialize(8);
        p= intialPuzzle8(m8,p);
        f= emptycel(p);
        printPuzzle(p);
        System.out.println("puzzle f");
        printPuzzle(f);

        //c =debut(c);
    }

    public static setPuzzle intialPuzzle8(init8 m, setPuzzle p) {
        int [] t=new int[34];
        int u;
        for(int i=0;i<34;i++) {
            t[i]=0;
        }
        u =(int)(Math.random() * 34);
        p=remplirLigne(p,0,m.poss[u]);
        t[u]=1;
        if(u%2==0) {
            p=remplirLigne(p,1,m.poss[u+1]);
            t[u+1]=1;
        }
        else {
            p=remplirLigne(p,1,m.poss[u-1]);
            t[u-1]=1;
        }
        for(int i=1;i<p.size;i++) {
            if(i%2==0) {
                do
                    u =(int)(Math.random() * 34);
                while(t[u]==1);
                if(t[u]==0 && verifCond(p,i,m.poss[u])==1) {
                    t[u]=1;
                    p=remplirLigne(p,i,m.poss[u]);
                    if(u%2==0) {
                        p=remplirLigne(p,i+1,m.poss[u+1]);
                        t[u+1]=1;
                    }
                    else {
                        p=remplirLigne(p,i+1,m.poss[u-1]);
                        t[u-1]=1;
                    }
                }
                else {
                    i--;
                }
            }
        }
        return(p);
    }

}
