<template>
    <div>
        <head-top></head-top>
		<section class="data_section">
			<header class="section_title">图片数据统计</header>
			<el-row :gutter="20" style="margin-bottom: 10px;">
                <el-col :span="4"><div class="data_list today_head"><span class="data_num head">当日数据：</span></div></el-col>
				<el-col :span="4"><div class="data_list"><span class="data_num">{{new_pic}}</span> 新增图片</div></el-col>
				<el-col :span="4"><div class="data_list"><span class="data_num">{{new_normal_pic}}</span> 正常图片</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{new_abnormal_pic}}</span> 异常图片</div></el-col>
<!--                <el-col :span="4"><div class="data_list"><span class="data_num">{{from_spring_boot}}</span> 测试用 </div></el-col>-->

            </el-row>
            <el-row :gutter="20">
                <el-col :span="4"><div class="data_list all_head"><span class="data_num head">总数据：</span></div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{detected_pic}}</span> 已检测图片</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{normal_pic}}</span> 正常图片</div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num">{{abnormal_pic}}</span> 异常图片</div></el-col>
            </el-row>
		</section>
		<tendency :sevenDate='sevenDate' :sevenDay='sevenDay'></tendency>
    </div>
</template>

<script>
	import headTop from '../components/headTop'
	import tendency from '../components/tendency'
	import dtime from 'time-formater'
    import {get_data} from '@/api/getData'
	// import {userCount, orderCount, getUserCount, getOrderCount, adminDayCount, adminCount} from '@/api/getData'  从后台api获取数据
    export default {
        data() {
            return {
                new_pic: 10,
                new_normal_pic: 9,
                new_abnormal_pic: 1,
                detected_pic: 45,
                normal_pic: 43,
                abnormal_pic: 2,
                sevenDay: [],
                sevenDate: [[], [], []],
                // from_spring_boot: 4
            }
        },
        components: {
            headTop,
            tendency,
        },
        mounted() {
            this.initData();
            for (let i = 6; i > -1; i--) {
                const date = dtime(new Date().getTime() - 86400000 * i).format('YYYY-MM-DD');
                this.sevenDay.push(date)
            }
            this.getSevenData();
            // this.initData();
        },
        computed: {},
        methods: {

            async initData() {
                const today = dtime().format('YYYY-MM-DD');
                // Promise.all([userCount(today), orderCount(today), adminDayCount(today), getUserCount(), getOrderCount(), adminCount()])
                // .then(res => {
                // 	this.userCount = res[0].count;
                // 	this.orderCount = res[1].count;
                //     this.adminCount = res[2].count;
                //     this.allUserCount = res[3].count;
                //     this.allOrderCount = res[4].count;
                //     this.allAdminCount = res[5].count;
                // }).catch(err => {
                // 	console.log(err)
                // })
            },


            async getSevenData() {
                const apiArr = [[], [], []];

                this.sevenDay.forEach(item => {
                    // apiArr[0].push(userCount(item));
                    // apiArr[1].push(orderCount(item));
                    // apiArr[2].push(adminDayCount(item))
                });
                const promiseArr = [...apiArr[0], ...apiArr[1], ...apiArr[2]];
                Promise.all(promiseArr).then(res => {
                    const resArr = [[], [], []];
                    res.forEach((item, index) => {
                        if (item.status == 1) {
                            resArr[Math.floor(index / 7)].push(item.count)
                        }
                    });
                    this.sevenDate = resArr;
                }).catch(err => {
                    console.log(err)
                })
            },


            // for test

            // async test_getdata() {
            //
            //     // console.log(this.from_spring_boot);
            //     // 取得Promise中的对象
            //     let res_data = Promise.resolve(get_data());
            //     res_data.then(res => {
            //         console.log(res[0].sold)
            //     });


            // }
        }
    }





</script>

<style lang="less">
	@import '../style/mixin';

    /*.tu{*/
    /*    width: 500px;*/
    /*    height: 600px;*/
    /*}*/



	.data_section{
		padding: 20px;
		margin-bottom: 40px;
		.section_title{
			text-align: center;
			font-size: 30px;
			margin-bottom: 10px;
		}
		.data_list{
			text-align: center;
			font-size: 14px;
			color: #666;
            border-radius: 6px;
            background: #E5E9F2;
            .data_num{
                color: #333;
                font-size: 26px;

            }
            .head{
                border-radius: 6px;
                font-size: 22px;
                padding: 4px 0;
                color: #fff;
                display: inline-block;
            }
        }
        .today_head{
            background: #FF9800;
        }
        .all_head{
            background: #20A0FF;
        }
	}
    .wan{
        .sc(16px, #333)
    }
</style>
