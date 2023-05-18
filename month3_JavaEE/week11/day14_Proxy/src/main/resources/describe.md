使用动态代理设计模式，将我们之前的三层架构代码加以优化。比如之前的代码中controller中需要依赖于ServiceImpl实例对象，service中需要频繁创建Mapper，同时还需要关闭SqlSession

最终效果如下：

controller

    @WebServlet("/hello")
    public class HelloController extends HttpServlet {
    
        UserService userService;
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = userService.name();
            System.out.println(name);
        }
    }



    
    public class UserServiceImpl implements UserService{
    
        UserMapper userMapper;
    
        public void setUserMapper(UserMapper userMapper) {
            this.userMapper = userMapper;
        }
    
        @Override
        public String name() {
            return userMapper.queryName();
        }
    }


UserMapper就是一个非常普通的mapper映射