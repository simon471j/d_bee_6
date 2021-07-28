# d_bee_6

### 工程介绍

- 使用了viewPager TabLayout BottomNavigationView实现工程(一个main Activity tabLayout嵌套在一个fragment中)

### 遇到的问题

- 遇到的问题主要出现在切换之后弹窗的提示 虽然我可以在FragmentPagerAdapter中进行提示 但是为了能了解Fragment的生命周期 我选择在Fragment中添加toast 这同时也降低了耦合度
- 与普通的Fragment不同 在ViewPager中有这样一个特点，当滑到某一个Tab时，它会同时加载这个tab的左右两个tab页，比如我从1页面切换到了2页面，那么3页面的onResume也被调用了，但是3页面其实对用户是不可见的。这时候我们就需要监听setUserVisibleHint来判断到底对用户是否可见。
- 当使用了setUserVisibleHint来判断到底对用户是否可见 我发现在使用toast时getContext()方法没有用 这会导致空指针异常 查询之后发现setUserVisibleHint执行的时候fragment还没有attach导致getContext()为空
- 为了解决上述的一个问题 我添加了MyApplication类 并将 `android:name=".MyApplication"`  写入了manifests中

```java
public class MyApplication extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
```

- 以上代码会有内存泄漏的提示(context不能声明为static) 但是这个类在整个应用程序生命周期都存活 所以不必担心
