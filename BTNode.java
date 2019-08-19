public class BTNode <E>
{

    private BTNode <E> par;
    private BTNode <E> left;
    private BTNode <E> right;
    private E elem;

    BTNode ( )
    {
        this(null,null,null,null);
    }

    BTNode(BTNode <E> p, BTNode <E> l, BTNode <E> r, E e)
    {
        par 	= p;
        left	= l;
        right	= r;
        elem	= e;
    }


    void setLeftChild(BTNode <E>  v) {left = v;}

    void setRightChild(BTNode <E>  v){right = v;}

    void setParent(BTNode <E>  v) 	{par = v;}

    void setElement(E e)             {elem = e;}
    
    public BTNode <E>  leftChild()       {return left;}

    public BTNode <E>  rightChild()    {return right;}

    public BTNode <E>  parent()          {return par;}

    public  E element()    	{return elem;}
    
}