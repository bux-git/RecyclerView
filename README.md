# RecyclerView 
1.SwipeRefreshLayout 下拉刷新    
2.上拉加载   
3.ItemTouchHelper  滑动删除 拖拽换位   
4.多类型Adapter   
避免类的类型检查与类型转型    
增强Adapter的扩展性    
增强Adapter的可维护性    
小结：

通过接口抽象，将所有与列表相关的Model抽象为Visitable，当我们在初始化数据源时就能以List<Visitable>的形式将不同类型的Model集合在列表中；      

通过访问者模式，将列表类型判断的相关代码抽取到TypeFactoryForList 中，同时所有列表类型对应的布局资源都在这个类中进行管理与维护，以这样的方式巧妙的增强了扩展性与可维护性；    

getItemViewType中不再需要进行if判断，通过数据源控制列表的布局类型，同时返回的不再是简单的布局类型标识，而是布局的资源ID（通过modelList.get(position).type()获取），进一步简化代码（在onCreateViewHolder中会体现出来）；    
![image](https://github.com/bux-git/RecyclerView/raw/master/recyclerView01.gif)