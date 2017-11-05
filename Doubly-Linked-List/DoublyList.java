class ListNode<T>{
    
    public T t;
    public ListNode<T> prev;
    public ListNode<T> next;
      
    public ListNode(T t){
        this.t = t;
        this.prev = null;
        this.next = null;        
    }

}

class DoublyList<T>{

  
    public ListNode<T> first;
  
    public void insertFirst(T t){
    
        if(first == null){
            first = new ListNode<T>(t);
        }else{
          
            ListNode<T> newList = new ListNode<T>(t);
          
            newList.next = first;
            first.prev = newList;
            first = newList;
            
        }
    }
  
    public void insertAfter(ListNode<T> after, T t){
        
        if(first == null){
            insertFirst(t);
        }else{
        
            ListNode<T> current = first;
          
            while(current.next != null && current != after){
            
                current = current.next;
            }
          
            ListNode<T> newList = new ListNode<T>(t);
          
            if(current.next == null){
                current.next = newList;
                newList.prev = current;
            }else{
                ListNode<T> next = current.next;
                current.next = newList;
                newList.prev = current;
                newList.next = next;
                next.prev = newList;
              
            }
            
        }
    }
  
    public void insertLast(T t){
        
        if(first == null){
            insertFirst(t);
        }else{
            
            ListNode<T> current = first;
          
            while(current.next != null){
                current = current.next;
            }
          
            ListNode<T> newList = new ListNode<T>(t);                        
            current.next = newList;
            newList.prev = current;
            
            
        }
    }
  
    public void deleteFirst(){
        
        if(first == null){
            return;
        }
      
        first = first.next;
        first.prev = null;
    }
  
    public void deleteAfter(ListNode<T> after){
    
        if(first == null){
            return;
        }
      
        ListNode<T> current = first;
        ListNode<T> prev = null;
      
        while(current.next != null && current != after){
            prev = current;
            current = current.next;
        }
      
    
        if(current.next == null){
            prev = prev.next;
            prev.prev = null;
            current.prev = null;
        }else{
            ListNode<T> temp = current.next.next;
            current.next = current.next.next;
            
            if(temp != null){
                temp.prev = current;    
            }
            
        }
      
    }
  
    public void deleteLast(){
        
        if(first == null){
            return;
        }
      
        if(first.next == null){
            first = null;
        }
        
        ListNode<T> current = first;
        ListNode<T> prev = null;
    
      
        while(current.next.next != null){
            current = current.next;          
        }
      
        current.next = current.next.next;
    
      
        
    }
  
    public void printList(){
        
        ListNode<T> current = first;
      
        while(current != null){
            System.out.println(current.t);
            current = current.next;
        }
      
        
    }
  
    
  
    public ListNode<T> getFirst(){
        return first;
    }  

}
