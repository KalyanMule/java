class Student{
   String name;
   String year;
   String regNo;
   String branch ;
   String type;
   static int no = 001;
   static int No = 501;
    
   Student(String year,String branch,String type,String name){
     this.name = name;
     this.year = year;
     this.branch = branch;
     this.type = type;
     
     this.generateRegistrationNo(year,branch,no);
    }
    private String takeBranchCode(String branch){
       String branchCode = "";
      if(branch.equalsIgnoreCase("Information Technology") ||branch.equalsIgnoreCase("IT")){
           return branchCode+="IT";
           
        }else if(branch.equalsIgnoreCase("Computer Science") || branch.equalsIgnoreCase("cs")){
          return branchCode += "CS";
        }else if(branch.equalsIgnoreCase("Electrical") || branch.equalsIgnoreCase("El")){
        return branchCode+="EL";
    }else{
    return branchCode;
    }Po 
    }
    private void generateRegistrationNo(String year,String branch,int no){
        String branchCode = takeBranchCode(branch);
       if(type.equalsIgnoreCase("regular")){
          this.regNo = year+"B"+branchCode+no;
           no++;
        }else if(type.equalsIgnoreCase("DSY")){
         
          this.regNo = Integer.parseInt(year)+"B"+branchCode+No;
           No++;
        }
    }
    public  void displayData(){
      System.out.println("Name : "+this.name);
      System.out.println("Branch:"+this.branch);
      System.out.println("Student type:"+this.type);
      System.out.println("registration No:"+this.regNo);
    }
  
  public static void main(String[] args){
     String Name = args[0];
     String year = args[1];
      String branch = args[2].toUpperCase();
      String type = args[3];
     Student s1 = new Student(year,branch,type,Name);
      s1.displayData();
    
   }
}

     
