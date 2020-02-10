<template>
  <div style="width: 1000px;height: 500px" class="student-box">
    <a-tabs defaultActiveKey="1" tabPosition= "left" >
        <a-tab-pane tab="已选课程" key="1"  >
            <a-table  :dataSource="allCourse" :pagination="pagination"  >
              <a-table-column title="课程名称" dataIndex="courseName" key="courseName" width="140px"></a-table-column>
              <a-table-column title="任课教师" dataIndex="courseTeacher" key="courseTeacher"></a-table-column>
              <a-table-column title="课时" dataIndex="period" key="period"></a-table-column>
              <a-table-column title="学生人数" dataIndex="studentNumber" key="studentNumber"></a-table-column>
              <a-table-column title="课程容量" dataIndex="maxStudentNumber" key="maxStudentNumber"></a-table-column>
              <a-table-column title="课程特色" dataIndex="tags" key="tags">
                <template slot-scope="tags">
                  <span>
                    <a-tag v-for="tag in tags" color="green" :key="tag">{{tag}}</a-tag>
                  </span>
                </template>
              </a-table-column>
              <a-table-column title="Action" dataIndex="key" key="key">
                <template slot-scope="key">
                      <a-button-group>
                      <a-button type="primary" :disabled="allCourse[key-1].selected" @click="click(key)" size="small"> <a-icon type="plus" /></a-button>
                      <a-button type="primary" :disabled="!allCourse[key-1].selected" @click="click(key)" size="small"><a-icon type="minus" /> </a-button>
                    </a-button-group>
                </template>
              </a-table-column>
            </a-table>
        </a-tab-pane>
      <a-tab-pane tab="全部课程" key="2">
          <a-table  :dataSource="allCourse" :pagination="pagination">
            <a-table-column title="课程名称" dataIndex="name" key="name" width="120px"></a-table-column>
            <a-table-column title="任课教师" dataIndex="teacher" key="teacher"></a-table-column>
            <a-table-column title="课时" dataIndex="period" key="period"></a-table-column>
            <a-table-column title="学生人数" dataIndex="studentNumber" key="studentNumber"></a-table-column>
            <a-table-column title="课程特色" dataIndex="tags" key="tags">
              <template slot-scope="tags">
                <span>
                  <a-tag v-for="tag in tags" color="green" :key="tag">{{tag}}</a-tag>
                </span>
              </template>
            </a-table-column>
            <a-table-column title="Action" dataIndex="key" key="key">
              <template slot-scope="key">
                    <a-button-group>
                    <a-button type="primary" :disabled="allCourse[key-1].selected" @click="click(key)" size="small"> <a-icon type="plus" /></a-button>
                    <a-button type="primary" :disabled="!allCourse[key-1].selected" @click="click(key)" size="small"><a-icon type="minus" /> </a-button>
                  </a-button-group>
              </template>
            </a-table-column>
          </a-table>
      </a-tab-pane>
    </a-tabs>

  </div>
</template>
<script>
 const columns = [
    {
      title: '课程名称',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '任课教师',
      dataIndex: 'teacher',
      key: 'teacher',
    },
    {
      title: '课时',
      dataIndex: 'period',
      key: 'period',
    },
    {
      title: '学生人数',
      dataIndex: 'studentnumber',
      key: 'studentnumber',
    },
    {
      title: '课程特色',
      key: 'tags',
      dataIndex: 'tags',
      scopedSlots: { customRender: 'tags' },
    },
    {
      title: '添加/删除',
      key: 'action',
      scopedSlots: { customRender: 'action' },
    },
  ];

  // const allCourse = [
  //   {
  //     key: 1,
  //     name:'数据结构',
  //     teacher: '张三',
  //     period:'48',
  //     studentnumber: '15/20',
  //     selected:false,
  //     tags: ['数据结构', '计算机'],
  //   },
  //   {
  //     key: 2,
  //     name:'操作系统',
  //     teacher: '李四',
  //     period:'32',
  //     studentnumber: '30/60',
  //     selected:true,
  //     tags: ['操作系统', '计算机'],
  //   },
  //   {
  //     key: 3,
  //     name:'计算机网络',
  //     teacher: '王五',
  //     period:'48',
  //     studentnumber: '45/60',
  //     selected:false,
  //     tags: ['计算机网络','计算机'],
  //   },
  //      {
  //     key: 4,
  //     name:'数据结构2',
  //     teacher: '张三2',
  //     period:'48',
  //     studentnumber: '15/20',
  //     selected:false,
  //     tags: ['数据结构', '计算机'],
  //   },
  //   {
  //     key: 5,
  //     name:'操作系统2',
  //     teacher: '李四2',
  //     period:'32',
  //     studentnumber: '30/60',
  //     selected:true,
  //     tags: ['操作系统', '计算机'],
  //   },
  //   {
  //     key: 6,
  //     name:'计算机网络2',
  //     teacher: '王五2',
  //     period:'48',
  //     studentnumber: '45/60',
  //     selected:false,
  //     tags: ['计算机网络','计算机'],
  //   },
  // ];
  export default {
    data() {
      return {
          allCourse:[],
          selected:[false,true],
          pagination:{
          defaultPageSize:3,
            }
      };
    },
    computed:{

    },
    watch:{
      
    },
    beforeCreate(){
       this.$http({
            method:'get',
            url:"http://localhost:8100/course/get",
          }).then(res =>{
            var data=new Array()
            data = res.data
            data.forEach(element => {
              element.tags = element.tags.split(",")
            });
            this.allCourse = res.data
          })
    },
    methods: {
      callback(val) {
      },
      click(key){
        this.$set(this.allCourse[key-1],'selected',!this.allCourse[key-1].selected)
      },
      refresh(key){
        alert(this.activeKey)
        switch(key){
          case 1:
            this.$http({
            method:'get',
            url:"http://localhost:8100/course/get",
          }).then(res =>{
            var data=new Array()
            data = res.data
            data.forEach(element => {
              element.tags = element.tags.split(",")
            });
            this.allCourse = res.data
          })
        }
      }
    },
  };
</script>
<style scoped>
.student-box{
  margin: 40px auto 0;
}
</style>
