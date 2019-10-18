import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);

// 现在不太用 require.ensure了
// const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
// const manage = r => require.ensure([], () => r(require('@/page/manage')), 'manage');
// const home = r => require.ensure([], () => r(require('@/page/home')), 'home');
// const addShop = r => require.ensure([], () => r(require('@/page/addShop')), 'addShop');
// const addGoods = r => require.ensure([], () => r(require('@/page/addGoods')), 'addGoods');
// const userList = r => require.ensure([], () => r(require('@/page/userList')), 'userList');
// const shopList = r => require.ensure([], () => r(require('@/page/shopList')), 'shopList');
// const foodList = r => require.ensure([], () => r(require('@/page/foodList')), 'foodList');
// const orderList = r => require.ensure([], () => r(require('@/page/orderList')), 'orderList');
// // const adminList = r => require.ensure([], () => r(require('@/page/adminList')), 'adminList');
// const visitor = r => require.ensure([], () => r(require('@/page/visitor')), 'visitor');
// const newMember = r => require.ensure([], () => r(require('@/page/newMember')), 'newMember');
// const uploadImg = r => require.ensure([], () => r(require('@/page/uploadImg')), 'uploadImg');
// const vueEdit = r => require.ensure([], () => r(require('@/page/vueEdit')), 'vueEdit');
// const adminSet = r => require.ensure([], () => r(require('@/page/adminSet')), 'adminSet');
// const sendMessage = r => require.ensure([], () => r(require('@/page/sendMessage')), 'sendMessage');
// const explain = r => require.ensure([], () => r(require('@/page/explain')), 'explain');
// 使用import 代替

// index_mode
const login = () => import('@/page/login');
const manage = () => import('@/page/manage');
const home = () => import('@/page/home');

const test = () => import('@/page/test');

// const visitor = () => import('@/page/visitor');
// const newMember = () => import('@/page/newMember');
// const uploadImg = () => import('@/page/uploadImg');
// const vueEdit = () => import('@/page/vueEdit');
// const adminSet = () => import('@/page/adminSet');
// const sendMessage = () => import('@/page/sendMessage');
// const explain = () => import('@/page/explain');


// data_mode
// const userList = () => import('@/page/data_mode/userList');
// const foodList = () => import('@/page/data_mode/foodList');
// const orderList = () => import('@/page/data_mode/orderList');
// const shopList = () => import('@/page/data_mode/shopList');

// add_data_mode
// const addGoods = () => import('@/page/add_data_mode/addGoods');
// const addShop = () => import('@/page/add_data_mode/addShop');

// picture_mode
const ele_detect = () => import('@/page/picture_mode/ele_detect');
const hot_detect = () => import('@/page/picture_mode/hot_detect');






const routes = [
	{
		path: '/',
		component: login
	},
	{
		path: '/manage',
		component: manage,
		name: '',
		children: [{
			path: '',
			component: home,
			meta: [],
		},{
		    path:'/ele_detect',
            component: ele_detect,
            meta: ['图像识别','电熔图片检测'],
        }, {
            path: '/hot_detect',
            component: hot_detect,
            meta: ['图像识别', '热熔图片检测'],
        },
        {
            path:'/test',
            component: test,
            meta:['测试用']
        }
        // },{
		// 	path: '/addShop',
		// 	component: addShop,
		// 	meta: ['添加数据', '添加商铺'],
		// },{
		// 	path: '/addGoods',
		// 	component: addGoods,
		// 	meta: ['添加数据', '添加商品'],
		// },{
		// 	path: '/userList',
		// 	component: userList,
		// 	meta: ['数据管理', '用户列表'],
		// },{
		// 	path: '/shopList',
		// 	component: shopList,
		// 	meta: ['数据管理', '商家列表'],
		// },{
		// 	path: '/foodList',
		// 	component: foodList,
		// 	meta: ['数据管理', '食品列表'],
		// }, {
        //     path: '/orderList',
        //     component: orderList,
        //     meta: ['数据管理', '订单列表'],
        // },
		// },{
		// 	path: '/adminList',
		// 	component: adminList,
		// 	meta: ['数据管理', '管理员列表'],
		// },{
        //  {
		// 	path: '/visitor',
		// 	component: visitor,
		// 	meta: ['图表', '用户分布'],
		// },{
		// 	path: '/newMember',
		// 	component: newMember,
		// 	meta: ['图表', '用户数据'],
		// },{
		// 	path: '/uploadImg',
		// 	component: uploadImg,
		// 	meta: ['文本编辑', 'MarkDown'],
		// },{
		// 	path: '/vueEdit',
		// 	component: vueEdit,
		// 	meta: ['编辑', '文本编辑'],
		// },{
		// 	path: '/adminSet',
		// 	component: adminSet,
		// 	meta: ['设置', '管理员设置'],
		// },{
		// 	path: '/sendMessage',
		// 	component: sendMessage,
		// 	meta: ['设置', '发送通知'],
		// },{
		// 	path: '/explain',
		// 	component: explain,
		// 	meta: ['说明', '说明'],
		// }
        ]
	}
];

export default new Router({
	routes,
	strict: process.env.NODE_ENV !== 'production',
})
