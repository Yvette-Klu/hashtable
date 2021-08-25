/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtablelinearprobing;

/**
 *
 * @author Eliezer Klu
 */
public class HashTableLinearProbing {

    /**
     * @param args the command line arguments
     */
    
      private int currentSize, maxSize ;
    private String[] keys;
    private String[] value;
    
    public HashTableLinearProbing(int cap) {
         currentSize = 0;
        maxSize = cap;
        keys = new String [maxSize];
        value = new String[maxSize];
    }
    
    //CLEARS HASHTABLE
     public void clear()
    {
        currentSize = 0;
        keys = new String[maxSize];
        value = new String[maxSize];
        
        System.out.println("hashtable has been cleared");
    }
     
     //GETS THE SIZE
      public int getSize() {
          return currentSize; 
      }
      // CHECKS WHETHER IT IS FULL
        public boolean isFull(){
       if(currentSize == maxSize) {
            System.out.println(true + " it is full");
        }else{
           System.out.println(false + " it is not full");
       }
       return true;
    }
        
        //checks whether it is empty
        public boolean isEmpty() { 
            if(getSize() == 0){
                System.out.println(true + " it is empty");
            }else{
                System.out.println(false + " it is not empty");
            }
           return true;
        }
        
        //GETS HASHCODE FOR A GIVEN KEY
        private  int hash(String key){
    
        return key.hashCode() % maxSize;
    }
        
        
        //RETURNS VALUE FOR A GIVEN KEY
        public  String getValue(String key)
    {
        
        int hashValue = hash(key);
        while (keys[ hashValue] != null) {
            if (keys[ hashValue].equals(key))
                return value[ hashValue];
             hashValue = ( hashValue + 1) % maxSize;
            System.out.println(value[ hashValue]);
        }
        return null ;
    }
        
        
        //INSERTS KEY AND VALUE INTO THE ARRAY
        public void insert(String key, String val)
    {
        int lm = hash(key);
        int hashValue = lm;
 
        do {
            if (keys[ hashValue] == null) {
                keys[ hashValue] = key;
                value[ hashValue] = val;
                currentSize++;
                return ;
            }
 
            if (keys[ hashValue].equals(key)) {
                value[ hashValue] = val;
                return;
            }
 
            hashValue = ( hashValue + 1) % maxSize;
 
        }
 
        while ( hashValue != lm);
        
       
    }
        
        public boolean contains(String key)
    {
        return getValue(key) != null;
    }
        
        
        public void remove(String key)
    {
        if (!contains(key))
            return;
        
        int hashValue = hash(key);
        while (!key.equals(keys[hashValue]))
            hashValue = (hashValue + 1) % maxSize;
        keys[hashValue] = value[hashValue] = null;
 
        // rehash all keys
        for (hashValue = (hashValue + 1) % maxSize; keys[hashValue] != null;
             hashValue = (hashValue + 1) % maxSize) {
            String lm1 = keys[hashValue], lm2 = value[hashValue];
            keys[hashValue] = value[hashValue] = null;
            currentSize--;
            insert(lm1, lm2);
        }
        currentSize--;
    }
        
        
        
        
        // PRINT HASHTABLE
         public void printHashTable()
    {
        
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] + "    " + value[i] );
        ///System.out.println();
    }

 
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashTableLinearProbing hello = new HashTableLinearProbing(11);
        
        hello.insert("sue", "023456785");
        hello.insert( "ma","0266478903");
        hello.insert("jane","0233456789");
        hello.insert( "nike","0234567890");
        hello.insert( "jo","025567834");
        hello.insert("lorie","0233456198");
        hello.insert( "maya","054678234");
        hello.insert( "marjorie","0244567321");
        hello.insert( "max","023456129");
        
        
        hello.isFull();
        hello.isEmpty();

       
        hello.printHashTable();
         
         hello.remove("jo");
         hello.remove("maya");
        
         
  
         System.out.println("Updated Table");
         hello.printHashTable();
         
         hello.clear();
         
          hello.isEmpty();
         
          hello.insert( "maya","054678234");
        hello.insert( "marjorie","0244567321");
        hello.insert( "max","023456129");
         hello.printHashTable();
        
         
        
        
        
        
        
    }
    
}
