public static void display(int size){
        int size1 = size ;
        if(size%2 ==0) size1 +=1 ;
        for(int ln = 1 ; ln <= size ; ln++){
          for(int i = 1 ; i<=(size/2) ; i++){
            if(i == 1 || i == size/2-ln+1 || size/2-i+ln == size-1 )System.out.print("*");
            else System.out.print(" ");
              
          }
          System.out.print("  ");
        for(int i = 1 ; i <=size ;i++){
               if((ln == 1 && i == 1)|| (ln==1 && i ==size))
               System.out.print(" ");
                else if ( i ==1 ||i==size || ln ==size/2+1 || ln ==1)
                System.out.print("*");
                else 
                System.out.print(" ");
        }
        System.out.print("  ");
        for(int i = 1 ; i <=size ;i++){
               
                if ( i ==1 ||ln ==size)
                System.out.print("*");
                else 
                System.out.print(" ");
        }
         System.out.print(" ");
    
            for(int i = 1 ; i <= size1 ; i++){
                if(ln <= size/2+1){
                    if(i == ln || i+ln == size1+1)
                     System.out.print("*");
                    else  
                    System.out.print(" ");
                }
                else{
                    if(i==size/2+1) 
                    System.out.print("*");
                    else
                    System.out.print(" ");
                }
            }
            System.out.print(" ");
            for(int i = 1 ; i <=size ;i++){
                if((ln == 1 && i == 1)|| (ln==1 && i ==size))
                System.out.print(" ");
                else if ( i ==1 ||i==size || ln ==size/2+1 || ln ==1)
                System.out.print("*");
                else 
                System.out.print(" ");
            }
            System.out.print(" ");
            for(int i =1 ; i<= size ; i++){
                if(i == ln || i == size || i==1 )System.out.print("*");
                else System.out.print(" ");
            }
          
          
        System.out.println();
    }
    
}
