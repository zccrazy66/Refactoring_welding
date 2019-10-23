<template>
    <div>
        <head-top></head-top>
        <span id="ele_pic_title"> 电熔图片检测 </span>
        <br><br>
        <div>
            <div id="ele_pic" style="display:inline-block">
                <el-upload
                class="el-upload-dragger"
                :data="getinputdata()"
                name="picture"
                :action="ApiPic"
                :show-file-list="false"
                accept="image/*"
                :on-success="handleSuccess"
                :on-error="handleError"
                :before-upload="handleBeforeUpload"
                :on-progress="handleProgress"
                :onchange="onchange"
                :file-list="fileList"
                drag
            >
                <img :src="imageUrl"  v-if="imageUrl" style="height: 400px;width: 600px">
            </el-upload>
            </div>
            <div style="display:inline-block">
                <img :src="'data:image/jpg;base64,'+base64_code" v-if="base64_code != null && error_code == null" style="width: 600px;height: 400px">
            </div>
            <div style="display:inline-block" class="box1">
                <span>{{error_code}}</span>
                <div v-if="error_code == null">
                    <span v-if="comprehensive_judgement_type != null">综合缺陷为： {{ comprehensive_judgement_type}}</span> <br>
                    <span v-if="comprehensive_judgement_level != null">综合等级为： {{ comprehensive_judgement_level }} </span><br>
                    <span v-if="detect_confidence !=null">综合置信度为： {{detect_confidence}} %</span><br><br>
                    <span v-if="chengcha_sign !=null">{{chengcha_sign}}<br></span>
                    <span v-if="over_cold_welding_sign!=null">{{over_cold_welding_sign}} :         {{over_cold_welding_value}} mm<br></span>
                    <span v-if="dislocation_sign!=null">{{dislocation_sign}}:                {{dislocation_value}}<br></span>
                    <span v-if="hole_sign!=null">{{hole_sign}}:                       {{hole_value}}<br></span>
                    <span v-if="impurity_sign!=null">{{impurity_sign}}:                   {{impurity_value}}<br></span>
                </div>
            </div>
        </div>
        <span>
            请输入电阻丝到特征线的距离:
            <el-input
                class="input_number"
                v-model="input_number"
                clearable
            >
            </el-input>
        </span>
    </div>

</template>

<script>

    import headTop from '../../components/headTop'
    export default {
        components: {
            headTop,
        },
        data(){
            return{
                /* 这里是传回来展示用的数 */
                error_code:null,
            	comprehensive_judgement_level:null,
                comprehensive_judgement_type:null,
                detect_confidence:null,
                chengcha_sign:null,
                over_cold_welding_sign:null,
                hole_sign:null,
                dislocation_sign:null,
                impurity_sign:null,
                base64_code:null,

                input_number:10,
                fileList:[],
                accept: "image/*",
                ApiPic:'http://192.168.1.120:8083/api/picture',
                imageUrl:'/static/click.jpg'
            }
        },
        methods:{
            beforeUpload(file){
                // console.log('file is ' + file + 'data is' +data)
            },
            handleError(err, rawFile) {
                console.log(
                    "Error holding !",
                    err,
                    rawFile,
                    this.imageUrl
                )

            },
            handleSuccess(res, file, fileList) {
                console.log(res);
                this.error_code = res.error_code;
                this.comprehensive_judgement_level = res.comprehensive_judgement_level;
                this.comprehensive_judgement_type = res.comprehensive_judgement_type;
                this.detect_confidence = res.detect_confidence.substring(0,4);
                this.chengcha_sign = res.chengcha_sign;
                this.over_cold_welding_sign = res.over_cold_welding_sign;
                this.over_cold_welding_value = res.over_cold_welding_value;
                this.dislocation_sign = res.dislocation_sign;
                this.dislocation_value = res.dislocation_value;
                this.hole_sign = res.hole_sign;
                this.hole_value = res.hole_value;
                this.impurity_sign = res.impurity_sign;
                this.impurity_value = res.impurity_value;
                this.base64_code = res.image;
                this.imageUrl = URL.createObjectURL(file.raw)
            },
            handleProgress(ev, rawFile, fileList) {
                console.log(
                	'ev is ' + ev,
                	'rawFile is' + rawFile,
                    'fileList is' + fileList
                )
            },
            handleBeforeUpload(){

            },
            onchange(file, fileList){
                var _this = this;
                var event = event || window.event;
                var file = event.target.files[0];
                var reader = new FileReader();
                //转base64
                reader.onload = function(e) {
                    _this.imageUrl = e.target.result //将图片路径赋值给src
                };
                reader.readAsDataURL(file);

            },
            getinputdata(){
				return {
					"test_length":this.input_number
                }
            }

        }
    }




</script>

<style>

    #ele_pic_title{
        font-size: 30px;
        color: #000000;
        margin-top: 60px;
        /*top: 20px;*/
        margin-left: 30px;
    }



    .box1{
        position: absolute;
        /*margin-left: 70px;*/
        margin-bottom: 30px;
        font-size: 20px;
        color: #ff2a37;
    }
    /* 全局改变上传拖拽框... */
    .el-upload-dragger{
        width: 600px;
        height: 400px;
    }

    .input_number{
        width: 230px;
    }
</style>

