//import java.util.*;
//import java.lang.*;
public class BSTree <E> {
	private BTNode<E> root;
	public BSTree(BTNode<E> r) {
		root=r;
	}
    public boolean isRoot(BTNode <E> v){ // Node is root if parent is null
        return (v.parent() == null);    }

    public boolean isInternal(BTNode <E> v){ //Node is internal if it has at least one child
        return (v.leftChild() != null || v.rightChild() != null);    }

    public boolean isExternal(BTNode <E> v){//Node is external if both children are null
        return (v.leftChild() == null && v.rightChild() == null);    
    }

    public boolean isRightChild(BTNode<E> v){//Node is right child if it equals its parent's right child
        if (isRoot(v)) return false;
        return (v == (v.parent()).rightChild());
    }

    public boolean isLeftChild(BTNode<E>  v){//Node is left child if it equals its parent's left child
        if (isRoot(v)) return false;
        return (v == (v.parent()).leftChild());    }
    
    public boolean[] hasLR(BTNode<E> v) {
    	boolean[] a= {false,false};
    	if(v.leftChild()!=null) {
    		a[0]=true;
    	}
    	if(v.rightChild()!=null) {
    		a[1]=true;
    	}
    	return a;
    }
    public int lca(BTNode<Integer> root ,int a,int b){
    	if(root.element()!=null) {
	    	if(root.element()>a&&root.element()>b) {
	    		return lca(root.leftChild(),a,b);
	    	}else if(root.element()<a&&root.element()<b) {
	    		return lca(root.rightChild(),a,b);
	    	}else {
	    		return root.element();
	    	}
    	}else {
    		return -1;
    	}
    	
    }
	public void insert(BTNode<E> r,E e) {
		BTNode<E> n=new BTNode<E>();
		n.setElement(e);
		if(r.element()==null) {
			root =r;
			r.setElement(e);
		}
		else if(!isExternal(r)) {
			if(((r.leftChild()==null && (r.element().toString()).compareTo( e.toString())>=0)||(r.rightChild()==null && (r.element().toString()).compareTo(e.toString())<0))) {
				if(r.leftChild()==null) {
					r.setLeftChild(n);
					n.setParent(r);
				}
				else {
					r.setRightChild(n);
					n.setParent(r);
				}
			}
			else {
				if((r.element().toString()).compareTo(e.toString())>=0) {
					insert(r.leftChild(),e);
				}
				else {
					insert(r.rightChild(),e);
				}
			}
		}
		else {
			if((r.element().toString()).compareTo(e.toString())>=0) {
				r.setLeftChild(n);
				n.setParent(r);
			}
			else {
				r.setRightChild(n);
				n.setParent(r);
			}
		}
	}
	
	public void printTree(BTNode<E> r,int c) {
		if(isExternal(r)) {
			System.out.println(r.element()+"\t"+(c));
			return;
		}
		if(hasLR(r)[0]) {
			printTree(r.leftChild(),c+1);
		}
		System.out.println(r.element()+"\t"+c);
		if(hasLR(r)[1]) {
			printTree(r.rightChild(),c+1);
		}
		
	}
	public BTNode<E> search(BTNode<E> r,E e) throws BTNodeException{
		if(r.element().equals(e)) {
			System.out.println("Object found!");
			return r;
		}
		if(isExternal(r)) {
			System.out.println("Element Not Found");
			throw new BTNodeException("Node not found");
		}
		if(((String) r.element()).compareTo((String) e)>=0) {
			return search(r.leftChild(),e);
		}
		else {
			return search(r.rightChild(),e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*BTNode<String> rootN =new BTNode<String>();
		BSTree<String> a= new BSTree<String>(rootN);
		//a.insert(rootN, "Shivam1");
		a.insert(rootN, "Hatim");
		a.insert(rootN, "Mihir");
		a.insert(rootN, "Ishan");
		a.insert(rootN, "Karan");
		a.insert(rootN, "Samit");
		a.insert(rootN, "Apple");
		try {
			BTNode<String> temp =a.search(rootN, "Hatim");
			System.out.println(temp.element());
			System.out.println(temp.parent().element());
			
		}catch(BTNodeException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			
			System.out.println("The Searched object is a root!!");
		}
		a.printTree(rootN,0);*/
		
		BTNode<Integer> rootN1 =new BTNode<Integer>();
		BSTree<Integer> a1= new BSTree<Integer>(rootN1);
		Integer [] nL= {50,32,52,75,23,46,23,12,47,95,83,33,85,92,99,43,75};
		for(int i=0;i<nL.length;i++) {
			a1.insert(rootN1, nL[i]);
		}
		//a1.printTree(rootN1, 0);
		System.out.println("Test1(85,92) =  "+a1.lca(rootN1,85,92));
		System.out.println("Test2(12,43) =  "+a1.lca(rootN1,12,43));
		System.out.println("Test3(75,33) =  "+a1.lca(rootN1,75,33));
		System.out.println("Test4(83,33) =  "+a1.lca(rootN1,83,33));
	}

}