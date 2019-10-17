<template>

    <div>
        <head-top></head-top>
        <span id="ele_pic_title"> 电熔图片检测 </span>
        <br><br>

<!--        <div id="img_show">-->

<!--            <img id="img_res" style="width: 500px; height: 300px;">-->

<!--        </div>-->

        <div id="ele_pic">

            <el-upload
                class="el-upload-dragger"
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
                <img v-if="imageUrl" :src="imageUrl" class="avatar">


            </el-upload>
        </div>






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
                fileList:[],
                accept: "image/*",
                ApiPic:'http://localhost:8080/api/picture',
                imageUrl:'/static/timg.jpg'
                // productImges: []
            }
        },
        methods:{

            beforeUpload(file){

            },



            handleError(err, rawFile) {
                console.log(
                    "Error holding !",
                    err,
                    rawFile,
                    this.ImagePicUrl
                )

            },
            handleSuccess(res, file, fileList) {
                console.log(
                    "The picture has been in it",
                    // res,
                    file,
                    fileList
                );
                this.imageUrl = URL.createObjectURL(file.raw)

                // console.log(file);
                // console.log(fileList)
            },
            handleProgress(ev, rawFile, fileList) {
                console.log(
                    "正在传输中....",
                    ev,
                    rawFile,
                    fileList
                )
            },
            handleBeforeUpload(){
                console.log(
                    "handleBeforeUpload"
                )
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

    .el-upload-dragger{
        /*margin-left: 20px;*/
        width: 600px;
        height: 400px;
    }

    .avatar{
        /*margin-left: 20px;*/
        width: 600px;
        height: 400px;
        /*margin-left: 50px;*/
        /*border-width: 10px;*/
    }

    .upload_button{
        position: absolute;
        margin-left: 800px;
        /*margin-top: 40px;*/
        top: 140px;
    }

</style>

