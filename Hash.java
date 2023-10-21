public class Hash{        
   

        
        public static void main(String[] args) {
            
            String str = "This is lovely day and i am very #happy #and i #am so #happy" 
            +"#today and #you are #also #blessed";
            
            String[] myArray = str.split(" ");
            int hashCount = 0;
            String hashTag = "";
            for(int i=0; i< myArray.length; i++){
                
                String isHash = myArray[i];
                if(isHash.startsWith("#")){
                    hashCount ++;
                    hashTag += isHash+" ";
                } 
            }

            if(hashCount>0){
                
                System.out.print("Hashtags found: "+hashTag.toString());
                //System.out.println(hashTag.toString());
            }else{
                System.out.println("No hashtags found!");
            }

    }
}