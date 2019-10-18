<template>

    <div>
        <first :test_number='test_number'></first>

<!--        <input v-model="test_number[3]">-->
    </div>

</template>

<script>

    import echarts_test from '../components/echarts_test'
    import {get_data} from '@/api/getData'

    export default {
		name: "",
        data(){
		    return{
		        test_number:[]
            }
        },
        components:{
		    "first" :echarts_test
        },
        mounted(){
            this.getData();
            // this.$emit('update_data', this.test_number)
        },
        methods:{
            async getData() {
                // 取得Promise中的对象
                let res_data = Promise.resolve(get_data());
                res_data.then(res => {
                    const resArr = [];
                    res.forEach((item, index) =>{
                        resArr.push(item.sold);
                    });
                    // console.log(resArr);
                    this.test_number = resArr;
                    // console.log(this.test_number)
                });
            }
        },

	}
</script>

<style scoped>

</style>
