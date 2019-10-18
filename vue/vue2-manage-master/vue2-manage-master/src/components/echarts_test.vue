<template>
    <div class="test_echarts">
<!--        <span> "show something" </span>-->
        <div id="echarts_table" style="width: 90%;height:450px;"></div>
    </div>
</template>

<script>
    import echarts from 'echarts'
	export default {
		name: "",
        props:['test_number'],
        mounted() {
            this.myChart = echarts.init(document.getElementById('echarts_table'));
            console.log(this.test_number);
            this.initData();
            // this.update();
        },

        data(){
		    return{
                option: {
                    title: { text: '在Vue中使用echarts' },
                    toolbox: {
                        show: true,
                        feature: {
                            dataZoom: {
                                yAxisIndex: 'none'
                            },
                            dataView: {readOnly: false},
                            magicType: {type: ['bar', 'line']},
                            restore: {},
                            saveAsImage:{}
                        }
                    },
                    xAxis: {
                        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                    },
                    yAxis: {
                        name: "销量"
                    },
                    series: [{
                        name: '销量',
                        type: 'bar',
                        data: this.test_number
                    }]
                }
            }
        },

        methods: {
		    initData(){
		        // const option = {
                //     title: { text: '在Vue中使用echarts' },
                //     toolbox: {
                //         show: true,
                //         feature: {
                //             dataZoom: {
                //                 yAxisIndex: 'none'
                //             },
                //             dataView: {readOnly: false},
                //             magicType: {type: ['bar', 'line']},
                //             restore: {},
                //             saveAsImage:{}
                //         }
                //     },
                //     xAxis: {
                //         data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                //     },
                //     yAxis: {
                //         name: "销量"
                //     },
                //     series: [{
                //         name: '销量',
                //         type: 'bar',
                //         data: this.test_number
                //     }]
                // };
                // 使用刚指定的配置项和数据显示图表。
                // console.log(this.test_number);

                this.option.series[0].data = this.test_number;
                this.myChart.setOption(this.option);
            },
        },
        watch:{
		    test_number:function () {
                this.initData();
            }
        }
    }
</script>

<style scoped>

</style>
