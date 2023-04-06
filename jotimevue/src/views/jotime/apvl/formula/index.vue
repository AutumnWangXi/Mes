<!--打样申请-->
<template>
  <div class="formula">
    <div class="titles" @click="gotback">发起申请》 打样申请</div>
    <div style="width:100%; display: flex; justify-content: center;">
      <el-form ref="form" :model="form" label-position="right" label-width="110px">
        <div class="formula-center">
          <el-row :gutter="24">
            <el-col :span="8" :offset="3">
              <div class="grid-content bg-purple">
                <div class="formula-li">
                  <el-form-item label="客户编号" :rules="({ required: true})">
                    <el-autocomplete
                      v-model="form.customerCode"
                      :fetch-suggestions="querySearchID"
                      placeholder="请输入内容"
                      value-key="customerCode"
                      @select="handleCustomerId"
                      @input="change($event)"
                    ></el-autocomplete>
                  </el-form-item>
                </div>
                <div class="formula-li" hidden>
                  <el-form-item label="客户编号">
                    <el-input v-model="form.customerId"></el-input>
                  </el-form-item>
                </div>
                <div class="formula-li">
                  <el-form-item label="样品名称" :rules="({ required: true})">
                    <el-input v-model="form.itemName" placeholder="请输入内容"></el-input>
                  </el-form-item>
                </div>
                <div class="formula-li">
                  <el-form-item label="样品类型" :rules="({ required: true})">
                    <el-select v-model="form.formulaType" placeholder="请选择" @change="formulaTypechange">
                      <el-option
                        v-for="dict in dict.type.sys_formula_type"
                        :key="dict.value"
                        :label="dict.label"
                        :value="dict.value"
                      />
                    </el-select>
                  </el-form-item>
                </div>
                <div class="formula-li">
                  <el-form-item label="样品剂型" :rules="({ required: true})">
                    <el-select v-model="form.formulaDosage" placeholder="请选择" @change="formulaDosagechange">
                      <el-option
                        v-for="dict in dict.type.sys_formula_dosage"
                        :key="dict.value"
                        :label="dict.label"
                        :value="dict.value"
                      />
                    </el-select>
                  </el-form-item>
                </div>
                <div class="formula-li">
                  <el-form-item label="打样类型" :rules="({ required: true})">
                    <el-select v-model="form.formulaMethod" placeholder="请选择打样类型" @change="formulaMethodchange">
                      <el-option
                        v-for="dict in dict.type.sys_formula_method"
                        :key="dict.value"
                        :label="dict.label"
                        :value="dict.value"
                      />
                    </el-select>
                    <el-input style="width: 35%"
                              v-if="this.form.formulaMethod === '05'"
                              placeholder="请输入"
                              v-model="form.formulationNo"
                    ></el-input>
                  </el-form-item>
                </div>
              </div>
            </el-col>
            <el-col :span="11">
              <div class="grid-content bg-purple">
                <div class="formula-li">
                  <el-form-item label="客户名称" :rules="({ required: true})">
                    <el-autocomplete
                      v-model="form.customerName"
                      :fetch-suggestions="querySearchAsync"
                      placeholder="请输入内容"
                      value-key="customerName"
                      @select="handleCustomerName"
                      @input="change($event)"
                    ></el-autocomplete>
                  </el-form-item>
                </div>
                <div class="formula-li">
                  <el-form-item label="品牌名称" :rules="({ required: true})">
                    <el-input v-model="form.brand" type="text" placeholder="请输入品牌名称"/>
                  </el-form-item>
                </div>
                <div class="formula-liul">
                  <el-form-item label="销售地区" :rules="({ required: true})">
                    <el-select v-model="salesDistrictList" multiple placeholder="请选择"
                               @change="salesDistrictchange">
                      <el-option
                        v-for="dict in dict.type.sys_sales_district"
                        :key="dict.value"
                        :label="dict.label"
                        :value="dict.value"
                      />
                    </el-select>
                    <el-input v-if="this.salesDistrictStatus" v-model="form.salesDistrictNote" type="text"
                              placeholder="请输入销售地区"/>
                  </el-form-item>
                  <!-- <div class="popup-ui" v-if="this.form.salesDistrict ==='05'"> -->

                </div>
                <div class="formula-li">
                  <el-form-item label="销售渠道" :rules="({ required: true})">
                    <el-select v-model="salesChannelList" multiple placeholder="请选择" @change="salesChannelchange">
                      <el-option
                        v-for="dict in dict.type.sys_sales_channel"
                        :key="dict.value"
                        :label="dict.label"
                        :value="dict.value"
                      />
                    </el-select>
                  </el-form-item>
                </div>

                <div class="formula-li">
                  <el-form-item label="开发背景" :rules="({ required: true})">
                    <el-select v-model="form.devBackground" placeholder="请选择" @change="devBackgroundchange">
                      <el-option
                        v-for="dict in dict.type.sys_dev_background"
                        :key="dict.value"
                        :label="dict.label"
                        :value="dict.value"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </div>
            </el-col>
          </el-row>
        </div>
        <!-- 2 -->
        <div class="formula-center" style="padding-top: 30px;border-top: 1px solid #c9c9c9;">
          <el-row :gutter="24">
            <el-col :span="8" :offset="3">
              <div class="grid-content bg-purple">
                <!--第二部分-->
                <div class="formula-li">
                  <el-form-item label="使用部位" :rules="({ required: true})">
                    <el-select v-model="form.usedPart" placeholder="请选择使用部位" @change="usedPartchange">
                      <el-option
                        v-for="dict in dict.type.sys_used_part"
                        :key="dict.value"
                        :label="dict.label"
                        :value="dict.value"
                      />
                    </el-select>
                  </el-form-item>
                </div>
                <div class="formula-li">
                  <el-form-item label="成品容量" :rules="({ required: true})">
                    <el-select v-model="form.unit" placeholder="请选择单位" @change="unitchange">
                      <el-option
                        v-for="dict in dict.type.sys_product_volumes"
                        :key="dict.value"
                        :label="dict.label"
                        :value="dict.label"
                      />
                    </el-select>
                    <el-input style="width: 35%" v-if="this.form.unit === 'ML' || this.form.unit === 'G'"
                              placeholder="请输入容量" @change="finishProductVolumeschange"
                              v-model="form.finishProductVolumes"></el-input>
                  </el-form-item>
                </div>
                <div class="formula-li">
                  <div class="formula-li">
                    <el-form-item label="成品售价" :rules="({ required: true})">
                      <el-select v-model="form.erpCustomer" placeholder="请选择成品售价" @change="erpCustomerchange">
                        <el-option
                          v-for="dict in dict.type.sys_erp_customer"
                          :key="dict.value"
                          :label="dict.label"
                          :value="dict.value"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                  <div class="formula-li">
                    <el-form-item label="内料单价" :rules="({ required: true})">
                      <el-input v-model="form.interMaterialsPrice" @change="interMaterialsPricechange" type="text"
                                placeholder="请输入内料单价"/>
                      元/KG
                    </el-form-item>
                  </div>
                </div>
              </div>
            </el-col>
            <!--        <el-col :span="4">-->
            <!--          <div class="popup-ui" v-if="" style="height: 59px">-->
            <!--            <el-form-item label="" :rules="({ required: false})">-->

            <!--            </el-form-item>-->
            <!--          </div>-->
            <!--          <div class="popup-ui" style="height: 59px">-->
            <!--            <el-form-item label="成品容量" :rules="({ required: false})" v-if="this.form.unit == 'ML' || this.form.unit == 'KG'">-->
            <!--              <el-input style="width: 80%;" placeholder="请输入成品容量" v-model="form.finishProductVolumes" ></el-input>-->
            <!--            </el-form-item>-->
            <!--          </div>-->
            <!--          <div class="popup-ui" v-if="" style="height: 59px">-->
            <!--            <el-form-item style="margin-left: 0px" label="元/KG" :rules="({ required: false})">-->

            <!--            </el-form-item>-->
            <!--          </div>-->
            <!--          <div class="popup-ui" v-if="">-->
            <!--            <el-form-item label="" :rules="({ required: false})">-->

            <!--            </el-form-item>-->
            <!--          </div>-->
            <!--        </el-col>-->

            <el-col :span="11">
              <div class="grid-content bg-purple">
                <!--第二部分-->
                <div class="formula-li">
                  <div class="formula-liul">
                    <el-form-item label="目标人群" :rules="({ required: true})">
                      <el-select v-model="form.applUser" placeholder="请选择" @change="applUserchange">
                        <el-option
                          v-for="dict in dict.type.sys_appl_user"
                          :key="dict.value"
                          :label="dict.label"
                          :value="dict.value"
                        >
                        </el-option>
                      </el-select>
                      <el-input v-if="this.form.applUser === '99'" v-model="form.applUserNote" type="text"
                                placeholder="请输入其他"/>
                    </el-form-item>
                    <!--		            <div class="popup-ui" v-if="this.form.applUser === '99'">-->
                    <!--		              <el-form-item label="备注" :rules="({ required: false})">-->
                    <!--		                <el-input v-model="form.applUserNote" type="text" placeholder="备注"/>-->
                    <!--		              </el-form-item>-->
                    <!--		            </div>-->
                  </div>
                  <div class="formula-liul">
                    <el-form-item label="适用肌肤" :rules="({ required: true})">
                      <el-select v-model="form.applSkinType" placeholder="请选择适用肌肤" @change="applSkinTypechange">
                        <el-option
                          v-for="dict in dict.type.sys_appl_skin_type"
                          :key="dict.value"
                          :label="dict.label"
                          :value="dict.value"
                        />
                      </el-select>
                      <el-input v-if="this.form.applSkinType === '99'" v-model="form.applSkinTypeNote" type="text"
                                placeholder="请输入其他"/>
                    </el-form-item>
                    <!--		            <div class="popup-ui" v-if="this.form.applSkinType === '99'">-->
                    <!--		              <el-form-item label="备注" :rules="({ required: false})">-->
                    <!--		                <el-input v-model="form.applSkinTypeNote" type="text" placeholder="备注"/>-->
                    <!--		              </el-form-item>-->
                    <!--		            </div>-->
                  </div>
                  <div class="formula-liul">
                    <el-form-item label="颜色&香型" :rules="({ required: true})">
                      <el-select v-model="form.colorAndFlavor" placeholder="请选择" @change="colorAndFlavorchange">
                        <el-option
                          v-for="dict in dict.type.sys_color_and_flavor"
                          :key="dict.value"
                          :label="dict.label"
                          :value="dict.value"
                        >
                        </el-option>
                      </el-select>
                      <el-input v-if="this.form.colorAndFlavor === '04'" v-model="form.colorAndFlavorNote" type="text"
                                placeholder="请输入内容"/>
                    </el-form-item>
                    <!--		            <div class="popup-ui" v-if="this.form.colorAndFlavor === '04'">-->
                    <!--		              <el-form-item label="备注" :rules="({ required: false})">-->
                    <!--		                <el-input v-model="form.colorAndFlavorNote" type="text" placeholder="备注"/>-->
                    <!--		              </el-form-item>-->
                    <!--		            </div>-->
                  </div>

                  <div class="formula-liul">
                    <el-form-item label="容器类型" :rules="({ required: true})">
                      <el-select v-model="form.containerType" placeholder="请选择" @change="containerTypechange">
                        <el-option
                          v-for="dict in dict.type.sys_container_type"
                          :key="dict.value"
                          :label="dict.label"
                          :value="dict.value"
                        />
                      </el-select>
                      <el-input v-if="this.form.containerType === '99'" v-model="form.containerTypeNote" type="text"
                                placeholder="请输入其他"/>
                    </el-form-item>
                    <!--		            <div class="popup-ui" v-if="this.form.containerType === '99'">-->
                    <!--		              <el-form-item label="容器类型备注" :rules="({ required: false})">-->
                    <!--		                <el-input v-model="form.containerTypeNote" type="text" placeholder="请输入容器类型备注"/>-->
                    <!--		              </el-form-item>-->
                    <!--		            </div>-->
                  </div>
                </div>
              </div>
            </el-col>
            <!--        <el-col :span="6">-->
            <!--          <div class="popup-ui" style="height: 59px">-->
            <!--&lt;!&ndash;            <el-form-item label="备注" :rules="({ required: false})" v-if="this.form.applUser === '99'">&ndash;&gt;-->
            <!--              <el-input v-if="this.form.applUser === '99'" v-model="form.applUserNote" type="text" placeholder="请输入备注"/>-->
            <!--&lt;!&ndash;            </el-form-item>&ndash;&gt;-->
            <!--          </div>-->
            <!--          <div class="popup-ui" style="height: 59px">-->
            <!--            <el-form-item label="备注" :rules="({ required: false})" v-if="this.form.applSkinType === '99'">-->
            <!--              <el-input v-model="form.applSkinTypeNote" type="text" placeholder="请输入备注"/>-->
            <!--            </el-form-item>-->
            <!--          </div>-->
            <!--          <div class="popup-ui" style="height: 59px">-->
            <!--            <el-form-item label="备注" :rules="({ required: false})" v-if="this.form.colorAndFlavor === '04'">-->
            <!--              <el-input v-model="form.colorAndFlavorNote" type="text" placeholder="请输入备注"/>-->
            <!--            </el-form-item>-->
            <!--          </div>-->
            <!--          <div class="popup-ui" style="height: 59px">-->
            <!--            <el-form-item label="备注" :rules="({ required: false})" v-if="this.form.containerType === '99'">-->
            <!--              <el-input v-model="form.containerTypeNote" type="text" placeholder="请输入备注"/>-->
            <!--            </el-form-item>-->
            <!--          </div>-->
            <!--        </el-col>-->
          </el-row>
          <el-row>
            <el-col :span="18" :offset="3">
              <div class="checkboxlist">
                <el-form-item label="使用功效要求" class="checkboxlists">
                  <el-checkbox-group v-model="usedEfficacyReqlist">
                    <el-checkbox label="01">保湿</el-checkbox>
                    <el-checkbox label="02">美白</el-checkbox>
                    <el-checkbox label="03">防晒</el-checkbox>
                    <el-checkbox label="04">祛痘</el-checkbox>
                    <el-checkbox label="05">滋养</el-checkbox>
                    <el-checkbox label="06">修护</el-checkbox>
                    <el-checkbox label="07">清洁</el-checkbox>
                    <el-checkbox label="08">卸妆</el-checkbox>
                    <el-checkbox label="09">抗皱</el-checkbox>
                    <el-checkbox label="10">紧致</el-checkbox>
                    <el-checkbox label="11">舒缓</el-checkbox>
                    <el-checkbox label="12">控油</el-checkbox>
                    <el-checkbox label="13">去角质</el-checkbox>
                    <el-checkbox label="14">爽身</el-checkbox>
                    <el-checkbox label="15">护发</el-checkbox>
                    <el-checkbox label="16">防断发</el-checkbox>
                    <el-checkbox label="17">去屑</el-checkbox>
                    <el-checkbox label="18">发色护理</el-checkbox>
                    <el-checkbox label="19">脱毛</el-checkbox>
                    <el-checkbox label="21">美容修饰</el-checkbox>
                    <el-checkbox label="22">裸妆</el-checkbox>
                    <el-checkbox label="23">亮光</el-checkbox>
                    <el-checkbox label="24">哑光</el-checkbox>
                    <el-checkbox label="25">持久</el-checkbox>
                    <el-checkbox label="26">水润</el-checkbox>
                    <el-checkbox label="33">新功效</el-checkbox>
                    <el-checkbox label="27">丝滑</el-checkbox>
                    <el-checkbox label="29">不沾杯</el-checkbox>
                    <el-checkbox label="30">防水</el-checkbox>
                    <el-checkbox label="31">遮瑕</el-checkbox>
                    <el-checkbox label="32">多色</el-checkbox>
                    <el-checkbox label="20">辅助剃须剃毛</el-checkbox>
                    <el-checkbox label="28">色彩高饱和度</el-checkbox>
                  </el-checkbox-group>
                </el-form-item>
                <el-form-item label="配方特别要求">
                  <el-checkbox-group v-model="specificaReqlist">
                    <el-checkbox label="01">无特别要求</el-checkbox>
                    <el-checkbox label="02">美修全绿</el-checkbox>
                    <el-checkbox label="03">无致痘成分</el-checkbox>
                    <el-checkbox label="04">无酒精</el-checkbox>
                    <el-checkbox label="05">无矿物油</el-checkbox>
                    <el-checkbox label="06">无色素</el-checkbox>
                    <el-checkbox label="07">无防腐剂</el-checkbox>
                    <el-checkbox label="08">如无法满足特别要求的，通知业务客户沟通</el-checkbox>
                  </el-checkbox-group>
                </el-form-item>
              </div>
            </el-col>
            <el-col :span="3"></el-col>
          </el-row>

        </div>

        <!-- 3 -->
        <div class="formula-center"
             style="padding-top: 15px;border-top: 1px solid #c9c9c9;border-bottom: 1px solid #c9c9c9;">
          <el-row>
            <el-col :span="18" :offset="3">
              <div style="width: 85%;">
                <el-form-item label="其他打样要求">
                  <el-input placeholder="请输入其他打样要求" type="textarea" v-model="form.note"></el-input>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
          <el-row :gutter="24">
            <el-col :span="8" :offset="3">
              <div class="grid-content bg-purple">
                <div class="formula-li">
                  <div class="formula-li" style="width: 420px;">
                    <el-form-item label="附件">
                      <el-upload
                        class="upload-demo"
                        :headers="thisToken"
                        drag
                        :action="fileUploadUrl"
                        multiple
                        :on-success="fileSuccess"
                        :on-error="fileError"
                        :on-preview="handlePreview"
                        :on-remove="handleRemove"
                        :before-remove="beforeRemove"
                        :limit="6"
                      >
                        <el-button size="small" @click="test(2)" type="primary">点击上传</el-button>
                      </el-upload>
                    </el-form-item>
                  </div>
                </div>
              </div>
            </el-col>
            <el-col :span="11">
              <div class="grid-content bg-purple">
                <div class="formula-li">
                  <div class="formula-liul">
                    <el-form-item label="样品图片">
                      <!--		              <el-input placeholder="请输入" v-model="form.formulaName"></el-input>-->
                    </el-form-item>
                    <el-upload
                      class="upload-demo"
                      :headers="thisToken"
                      drag
                      :action="fileUploadUrl"
                      multiple
                      :on-success="fileSuccess"
                      :on-error="fileError"
                      :file-list="fileList"
                      :on-preview="handlePreview"
                      :on-remove="handleRemove"
                      :before-remove="beforeRemove"
                      :limit="6"
                    >
                      <el-button size="small" @click="test(1)" type="primary">点击上传</el-button>
                    </el-upload>
                  </div>
                </div>
              </div>
            </el-col>
          </el-row>
        </div>

        <!-- 4 -->
        <div class="formula-center">
          <el-row :gutter="24">
            <el-col :span="8" :offset="3">
              <div class="grid-content bg-purple">
                <div class="formula-li">
                  <div style="margin-top: 30px" class="formula-li">
                    <el-form-item label="取样日期" :rules="({ required: true})">
                      <el-date-picker
                        v-model="form.samplingDate"
                        type="date"
                        placeholder="选择日期"
                        value-format="yyyy-MM-dd"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </div>
                  <div class="formula-li">
                    <el-form-item label="样品包装方式" :rules="({ required: true})">
                      <el-select v-model="form.packing" placeholder="请选择样品包装方式" @change="packingchange">
                        <el-option
                          v-for="dict in dict.type.sys_packing"
                          :key="dict.value"
                          :label="dict.label"
                          :value="dict.value"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </div>

                <div style="margin-left: 80px" class="formula-li">
                  <el-form-item label="是否加急">
                    <el-switch
                      v-model="form.isUrgent"
                      inactive-color="#13ce66"
                      inactive-value="1"
                      active-color="#ff4949"
                      active-value="2"
                    >
                    </el-switch>
                  </el-form-item>
                </div>
              </div>
            </el-col>
            <el-col :span="11">
              <div class="grid-content bg-purple">
                <div style="margin-top: 30px" class="formula-li">
                  <div class="formula-li">
                    <el-form-item label="样品数量" :rules="({ required: true})">
                      <el-input
                        placeholder="请输入样品容量"
                        v-model="form.formulaVolumes"
                        @change="formulaVolumeschange"
                      ></el-input>
                      G *
                      <el-input
                        placeholder="请输入样品数量"
                        v-model="form.formulaQty"
                        @change="demo"
                      ></el-input>
                      PCS
                    </el-form-item>
                  </div>
                  <div class="formula-li">
                    <el-form-item style="margin-right: 10px" label="抄送人">
                      <el-input
                        placeholder="请输入"
                        v-model="form.nickName"
                        @click.native="openDialog"
                      ></el-input>
                    </el-form-item>
                  </div>
                </div>
              </div>
            </el-col>
          </el-row>
          <el-row>
            <div style="margin-left: 160px" class="formula-li">
              <el-form-item label="审批:" :rules='({ required: true,message:"请选择审批分组", trigger:"blur"})' prop="apvlType">
                <el-select v-model="form.apvlType" placeholder="请选择">
                  <el-option
                    v-for="dict in moduleList"
                    :key="dict.moduleNo"
                    :label="dict.moduleName"
                    :value="dict.moduleNo"
                  />
                </el-select>
              </el-form-item>
            </div>
          </el-row>
        </div>
      </el-form>
    </div>
    <div
      class="formula-dialog-button">
      <el-button type="primary" @click="cancel">取消</el-button>
      <el-button type="primary" @click="submitForm">提交</el-button>
      <!--      <el-button type="primary" @click="printApprovalDetails">预览</el-button>-->
      <el-button type="primary" @click="previewclick">预览</el-button>
    </div>
    <Dialog @getData="list(arguments)" ref="ccToId"/>
    <!--  预览对话框-->
    <el-dialog
      title="预览"
      :visible.sync="preview"
      width="50%">
      <div class="previewtab">
        <table>
          <tr>
            <td>打样编号：</td>
            <td></td>
            <td>申请日期：</td>
            <td>{{ forms.date }}</td>
          </tr>
          <tr>
            <td>客户编号：</td>
            <td>{{ forms.customerCode }}</td>
            <td>客户名称：</td>
            <td>{{ forms.customerName }}</td>
          </tr>
          <tr>
            <td>发单日期：</td>
            <td>{{ forms.date }}</td>
            <td>取样日期：</td>
            <td>{{ forms.samplingDate }}</td>
          </tr>
          <tr>
            <td>品牌名称</td>
            <td colspan="3">{{ forms.brand }}</td>
          </tr>
          <tr>
            <td>样品名称</td>
            <td colspan="3">{{ forms.itemName }}</td>
          </tr>
          <tr>
            <td>样品类型</td>
            <td colspan="3">{{ forms.formulaType }}</td>
          </tr>
          <tr>
            <td>样品剂型</td>
            <td colspan="3">{{ forms.formulaDosage }}</td>
          </tr>
          <!--          <tr>-->
          <!--            <td>取样时间</td>-->
          <!--            <td colspan="3">{{ forms.samplingDate }}</td>-->
          <!--          </tr>-->
          <tr>
            <td>开发背景</td>
            <td colspan="3">{{ forms.devBackground }}</td>
          </tr>
          <tr>
            <td>销售地区</td>
            <td colspan="3">{{ forms.salesDistrictList }}</td>
          </tr>
          <tr>
            <td>销售渠道</td>
            <td colspan="3">{{ forms.salesChannelList }}</td>
          </tr>
          <tr>
            <td>打样类型</td>
            <td colspan="3">{{ forms.formulaMethod }}</td>
          </tr>
          <tr>
            <td>目标人群</td>
            <td colspan="3">{{ forms.applUser }}</td>
          </tr>
          <tr>
            <td>适用肌肤</td>
            <td colspan="3">{{ forms.applSkinType }}</td>
          </tr>
          <tr>
            <td>使用部位</td>
            <td colspan="3">{{ forms.usedPart }}</td>
          </tr>
          <tr>
            <td>使用功效要求</td>
            <td colspan="3">{{ forms.usedEfficacyReqlist }}</td>
          </tr>
          <tr>
            <td>配方特别要求</td>
            <td colspan="3">{{ forms.specificaReqlist }}</td>
          </tr>
          <tr>
            <td>颜色&香型</td>
            <td colspan="3">{{ forms.colorAndFlavor }}</td>
          </tr>
          <tr>
            <td>容器类型</td>
            <td colspan="3">{{ forms.containerType }}</td>
          </tr>
          <tr>
            <td>成品容量</td>
            <td colspan="3">{{ forms.finishProductVolumes }}</td>
          </tr>
          <tr>
            <td>成品预计售价</td>
            <td colspan="3">{{ forms.erpCustomer }}</td>
          </tr>
          <tr>
            <td>内料预计单价</td>
            <td colspan="3">{{ forms.interMaterialsPrice }}</td>
          </tr>
          <tr>
            <td>上传图片信息</td>
            <td colspan="3">{{ forms.ossUrl1s }}</td>
          </tr>
          <tr>
            <td>其他打样要求</td>
            <td colspan="3">{{ forms.note }}</td>
          </tr>
          <tr>
            <td>附件</td>
            <td colspan="3">{{ forms.ossUrl2s }}</td>
          </tr>
          <tr>
            <td>样品包装方式</td>
            <td colspan="3">{{ forms.packing }}</td>
          </tr>
          <tr>
            <td>样品数量</td>
            <td colspan="3">{{ forms.formulaQty }}</td>
          </tr>
          <tr>
            <td>抄送人</td>
            <td colspan="3">{{ forms.nickName }}</td>
          </tr>

        </table>
      </div>
      <span slot="footer" class="dialog-footer">
<!--        <el-button @click="previewcancel">取 消</el-button>-->
        <el-button @click="previewcancel">关 闭</el-button>
        <!--        <el-button type="primary" @click="preview = false">确 定</el-button>-->
      </span>
    </el-dialog>
  </div>

</template>
<script>
import FileUp from "@/components/FileUpload";
import Dialog from "./dialog.vue";
import {
  addFormula,
  listFormula,
  updateFormula,
  selectCustomerName,
  selectItemName,
  getFormula, deleteFile, getApvlType, printFormula, removeOssFile
} from "@/api/jotime/apvl/formula/formula";
import {getToken} from "@/utils/auth";
import DictData from "@/components/DictData";
import {addManage, listManage, removeFileManageData, updateFileManage} from "@/api/jotime/file/file";
import {printPdf, showDialog} from "@/api/jotime/apvl/common/common";
import { listModule } from "@/api/jotime/apvl/process/module";

export default {
  name: "Formula",
  components: {FileUp, Dialog},
  dicts: [
    "sys_formula_req",
    "sys_appl_user",
    "sys_erp_customer",
    "sys_product_type",
    "sys_color_and_flavor",
    "sys_container_type",
    "sys_dev_theme",
    "sys_appl_skin_type",
    "sys_dev_background",
    "sys_appl_skin_type",
    "sys_color_and_flavor",
    "sys_formula_type",
    "sys_formula_dosage",
    "sys_sales_district",
    "sys_sales_channel",
    "sys_used_part",
    "sys_packing",
    "sys_formula_method",
    "sys_erp_customer",
    "sys_product_volumes",
    "sys_apvl_type"
  ],

  data() {
    return {
      idArr: [],
      usedPartlist: ['ML', 'KG', '散装'],
      dialogVisible: false,
      fileList: [],
      type: '',
      // 销售地区其他显示隐藏
      districtsh: false,
      //预览对话框线束隐藏
      preview: false,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      //客户数据
      customerNameList: [],
      restaurants: [], //后端获取的数据
      customerName: "",
      itemNameList: [], //后端获取的物料数据
      itemName: "",
      timeout: null,
      //文本框状态控制
      applUserNote: false,//适用人群
      applSkinTypeNote: false,//适用皮肤类型
      colorAndFlavorNote: false,//颜色&香型
      salesDistrictNote: false,//销售地区
      salesDistrictList: [],
      salesDistrictStatus: false,
      salesChannelList: [],
      // 总条数
      total: 0,
      // 打样申请单 包含申请单状态表格数据
      formulaList: [],
      //标样图片url
      formulaUrl: [],
      //文件管理ID
      UUIDArr: [],
      //抄送人
      ccToId: "",
      //文件URL
      fileUrlArr: [],
      deleteFileUrl: [],
      //附件url
      attachmentUrl: "",
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        apvlNo: null,
        formulataskNo: null,
        formulationType: null,
        customerId: null,
        customerName: null,
        itemName: null,
        brand: null,
        issueDate: null,
        samplingDate: null,
        formulaReq: null,
        seriesName: null,
        applSnrType: null,
        applUser: null,
        devTheme: null,
        erpCustomer: null,
        applSkinType: null,
        colorAndFlavor: null,
        formulaName: null,
        formulaUrl1: null,
        formulaUrl2: null,
        formulaUrl3: null,
        finishProductVolumes: null,
        containerType: null,
        containerTypeNote: null,
        productType: null,
        formulationNo: null,
        compatibilityTestReq: null,
        productFormulaReq: null,
        formulaVolumes: null,
        formulaQty: null,
        proposerId: null,
        proposer: null,
        proposeTime: null,
        attachmentUrl1: null,
        isUrgent: null,
        status: null,
        note: null,
        creatorId: null,
        modifiedId: null,
        modifiedTime: null,

      },
      // 表单参数
      form: {
        applUserNote: null
      },
      // 预览参数
      forms: {
        ossUrl1: [],
        ossUrl2: [],
        salesDistrict: null,
        applUser: null,
        applSkinType: null,
        colorAndFlavor: null,
        containerType: null,
      },
      usedEfficacyReqlists: [
        {value: '01', name: '保湿'},
        {value: '02', name: '祛斑美白'},
        {value: '03', name: '防晒'},
        {value: '04', name: '祛痘'},
        {value: '05', name: '滋养'},
        {value: '06', name: '修护'},
        {value: '07', name: '清洁'},
        {value: '08', name: '卸妆'},
        {value: '09', name: '抗皱'},
        {value: '10', name: '紧致'},
        {value: '11', name: '舒缓'},
        {value: '12', name: '控油'},
        {value: '13', name: '去角质'},
        {value: '14', name: '爽身'},
        {value: '15', name: '护发'},
        {value: '16', name: '防断发'},
        {value: '17', name: '去屑'},
        {value: '18', name: '发色护理'},
        {value: '19', name: '脱毛'},
        {value: '20', name: '辅助剃须剃毛'},
        {value: '21', name: '美容修饰'},
        {value: '22', name: '裸妆'},
        {value: '23', name: '亮光'},
        {value: '24', name: '哑光'},
        {value: '25', name: '持久'},
        {value: '26', name: '水润'},
        {value: '27', name: '丝滑'},
        {value: '28', name: '色彩高饱和度'},
        {value: '29', name: '不沾杯'},
        {value: '30', name: '防水'},
        {value: '31', name: '遮瑕'},
        {value: '32', name: '多色'},
        {value: '33', name: '新功效'},
      ],
      usedEfficacyReqlist: [],
      specificaReqlist: [],
      specificaReqlists: [
        {value: '01', name: '无特别要求'},
        {value: '02', name: '美修全绿'},
        {value: '03', name: '无致痘成分'},
        {value: '04', name: '无酒精'},
        {value: '05', name: '无矿物油'},
        {value: '06', name: '无色素'},
        {value: '07', name: '无防腐剂'},
        {value: '08', name: '如无法满足特别需求的，通知业务与客户沟通'},
      ],
      options: [],
      value: "",
      development: "",
      thisToken: {Authorization: "Bearer " + getToken()},
      fileUploadUrl: process.env.VUE_APP_BASE_API + "/oss/uploadFile?busType=A01",
      // 表单校验
      rules: {
      },
      moduleType:[],
      moduleList:[]
    };
  },
  created() {
    this.getList();
    this.getData()
  },
  /** 查询审批流程名称列表 */
  computed: {
    search() {
      return this.customerNameList.filter(
        (customer) => customer.customerName.indexOf(this.value) !== -1
      );
    },
  },
  mounted() {
    DictData.install();
    //加载客户信息
    this.loadCustomerName();
    //加载物料信息
    // this.loadItemName();
    //开发主题
    this.getDicts('sys_dev_theme').then(response => {
      this.sysDevTheme = response.data
    })
    //适用人群
    this.getDicts('sys_appl_user').then(response => {
      this.sysApplUser = response.data
    })
    //容器类型
    this.getDicts('sys_container_type').then(response => {
      this.sysContainerType = response.data
    })
    //产品类型
    this.getDicts('sys_product_type').then(response => {
      this.sysProductType = response.data
    })
    //颜色和详情
    this.getDicts('sys_color_and_flavor').then(response => {
      this.sysColorAndFlavor = response.data
    })
    //颜色和详情
    this.getDicts('sys_appl_skin_type').then(response => {
      this.applSkinType = response.data
    })
    //审批
    this.getDicts('sys_apvl_type').then(response => {
      this.moduleType = response.data
      this.getListModule();
    })
  },
  methods: {
    getListModule() {
      let param ={};
      let menuType = "打样申请"
      this.moduleType.forEach(e =>{
        if (e.dictLabel == menuType) {
          param.groupCode = e.dictValue
        }
      })
      listModule(param).then(response => {
        this.moduleList = response.rows;
      });
    },
    //备注栏开启  1为 适用人群(其他)  2 适用皮肤类型(其他)  3颜色&香型(其他) 销售地区（其他）
    StatusOn(value, type) {
      switch (type) {
        case 1 || '1':
          if (value === 5 || value === '5') {
            this.applSkinTypeNote = true;
          } else {
            this.applSkinTypeNote = true;
          }
        case 2 || '2':
          if (value === 5 || value === '5') {
            this.applSkinTypeNote = true;
          } else {
            this.applSkinTypeNote = true;
          }
        case 3 || '3':
          if (value === 5 || value === '5') {
            this.colorAndFlavorNote = true;
          } else {
            this.colorAndFlavorNote = true;
          }
        case 4 || '4':
          if (value === 5 || value === '5') {
            this.salesDistrictNote = true;
          } else {
            this.salesDistrictNote = true;
          }
      }
    },
    getDictLabel(arr, dictValue) {
      for (let key in arr) {
        let arrElement = arr[key]
        if (arrElement.dictValue === dictValue) {
          return arrElement.dictLabel
        }
      }
    },
    //PDF打印
    printApprovalDetails() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          printFormula(this.form).then((response) => {
            let value = response.data
            let devTheme = this.getDictLabel(this.sysDevTheme, value.devTheme + "")
            value.devThemeName = devTheme
            let applUser = this.getDictLabel(this.sysApplUser, value.applUser + "")
            value.applUser = applUser
            let productType = this.getDictLabel(this.sysProductType, value.productType + "")
            value.productTypeName = productType
            let containerType = this.getDictLabel(this.sysContainerType, value.containerType + "")
            value.containerTypeName = containerType
            let applSkinType = this.getDictLabel(this.applSkinType, value.applSkinType + "")

            value.applSkinType = applSkinType
            let colorAndFlavor = this.getDictLabel(this.sysColorAndFlavor, value.colorAndFlavor + "")
            value.colorAndFlavor = colorAndFlavor
            let obj = {}
            obj.data = value
            printPdf(obj).then(res => {
              this.printPDF(res)
            })
          });
        }
      });
    },
    printPDF(stream) {
      /**
       * iframe src 为pdf 流 时，打印控件弹出后删除或造成控件隐藏
       * 所以等下一次打印触发清除上一次 创建的 iframe
       */

      let printBox = document.getElementById('print-stream-box')

      if (printBox) {
        document.body.removeChild(printBox)
      }

      let binaryData = []
      binaryData.push(stream.data)
      let blob = new Blob(binaryData, {type: 'application/pdf'})
      let url = URL.createObjectURL(blob)
      const iframe = document.createElement('iframe')
      iframe.setAttribute('id', 'print-stream-box')
      iframe.setAttribute('style', 'position:absolute;width:100px;height:100px;left:99999px;top:999999px;z-index:0px,')
      iframe.src = url
      document.body.appendChild(iframe)

      iframe.onload = function () {
        iframe.contentWindow.print()
        iframe.hidden
      }
    },
    getData() {
      if (this.$route.query.apvlNo != null) {
        getApvlType(this.$route.query.apvlNo).then((res) => {
          if (res.code === 200) {
            this.form = res.data
            this.salesChannelList = res.data.salesChannelList
            this.usedEfficacyReqlist = res.data.usedEfficacyReqList
            this.specificaReqlist = res.data.specificaReqList

          }
          this.form.finishProductVolumes = null
          this.form.interMaterialsPrice = null
          this.form.formulaVolumes = null
          this.form.formulaQty = null
        })
      }
    },
    change(e) {
      this.$forceUpdate()
    },
    // 取消按钮
    cancel() {
      this.deleteFile();
      window.history.go(-1);
    },
    /** 提交按钮 */
    submitForm() {
      for (let i in this.salesDistrictList) {
        if (this.salesDistrictList[i] == '其他') {
          this.salesDistrictList[i] = '99'
        }
      }
      this.form.idArr = JSON.stringify(this.UUIDArr);
      this.form.salesChannel = this.salesChannelList.toString()
      this.form.salesDistrict = this.salesDistrictList.toString()
      this.form.usedEfficacyReq = this.usedEfficacyReqlist.toString();
      this.form.specificaReq = this.specificaReqlist.toString();
      // console.log(this.form.usedEfficacyReq)
      debugger
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateFormula(this.form).then((response) => {
              if (response.code === 200) {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
                history.back(-1);
              } else {
                this.$modal.msgError(response.msg);
              }
            });
          } else {
            this.form.idArr = this.UUIDArr;
            addFormula(this.form).then((response) => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
              history.back(-1);
            });
          }
        }
      });
    },
    // 文件类型type(1)=打样申请文件 type(2)=附件
    test(type) {
      this.type = type
    },
    // 返回上一级
    gotback() {
      window.history.go(-1);
    },
    //抄送人弹出
    openDialog() {
      this.$refs.ccToId.dialogVisible = true;
    },
    // 抄送
    list(data) {
      this.form.ccToId = data[0] + "";
      this.form.nickName = data[1];
      this.$forceUpdate();
    },
    /**模糊查询*/
    //获取客户数据并赋值
    loadCustomerName() {
      let that = this;
      selectCustomerName()
        .then(function (res) {
          if (res.code === 200) {
            that.restaurants = res.value;
          } else {
            // 失败的提示
            that.$message.error(res.msg);
          }
        })
        .catch(function (err) {
          console.log(err);
        });
    },
    //查询搜索
    querySearchAsync(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString
        ? restaurants.filter(this.createStateFilter(queryString))
        : restaurants;
      cb(results);
    },
    createStateFilter(queryString) {
      return (state) => {
        return (
          state.customerName.toLowerCase().indexOf(queryString.toLowerCase()) >
          -1
        );
      };
    },
    //客户名称过滤搜索内容
    handleCustomerName(item) {
      this.form.customerId = item.id;
      this.form.customerCode = item.customerCode;
    },
    //客户编号查询搜索
    querySearchID(queryString, cb) {
      var restaurants = this.restaurants;
      var results = queryString
        ? restaurants.filter(this.createStateId(queryString))
        : restaurants;
      cb(results);
    },
    //过滤搜索内容
    createStateId(queryString) {
      return (state) => {
        return (
          state.customerCode.toLowerCase().indexOf(queryString.toLowerCase()) >
          -1
        );
      };
    },
    handleCustomerId(item) {
      this.form.customerName = item.customerName;
      this.form.customerId = item.id;
    },
    /**加载产品信息*/
    //查询物料数据
    loadItemName() {
      let that = this;
      let data = [6]
      selectItemName(data)
        .then(function (res) {
          if (res.code === 200) {
            that.itemNameList = res.value;
          } else {
            // 失败的提示
            that.$message.error(res.msg);
          }
        })
        .catch(function (err) {
          console.log(err);
        });
    },
    /**物料查询*/
    //查询搜索
    querySearchItem(queryString, cb) {
      var itemNameList = this.itemNameList;
      var results = queryString
        ? itemNameList.filter(this.createItemFilter(queryString))
        : itemNameList;
      cb(results);
    },
    //过滤搜索内容
    createItemFilter(queryString) {
      return (state) => {
        return (
          state.itemName.toLowerCase().indexOf(queryString.toLowerCase()) > -1
        );
      };
    },
    handleSelectItem(item) {
      this.form.itemName = item.itemName;
      this.form.itemId = item.id;
      this.form.itemNo = item.itemNo;
      this.form.itemCode = item.itemCode;
      this.$forceUpdate()
    },
    // 产品编号查询搜索
    querySearchCode(queryString, cb) {
      var itemNameList = this.itemNameList;
      var results = queryString
        ? itemNameList.filter(this.createItemFilter(queryString))
        : itemNameList;
      cb(results);
    },
    //过滤搜索内容
    createItemFilterCode(queryString) {
      return (state) => {
        return (
          state.itemNo.toLowerCase().indexOf(queryString.toLowerCase()) > -1
        );
      };
    },
    handleSelectCode(item) {
      this.form.itemName = item.itemName;
      this.form.itemId = item.id;
      this.form.itemNo = item.itemNo;
      this.form.itemCode = item.itemCode;
      this.$forceUpdate()
    },
    /**文件上传功能*/
    //移除所选文件
    handleRemove(file, fileList) {
      let data = {}
      data.deleteFileUrl = file.response.filepath
      data.fileUrl = file.response.ossUrl
      removeFileManageData(data).then(response => {
        this.$modal.msgSuccess('删除文件成功')
      })
    },

    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },

    handlePreview(file) {
      window.open(file.response.ossUrl)
    },
    //文件上传成功钩子
    fileSuccess(response, file, fileList) {
      let UUID = Math.floor(Math.random() * 1000000)
      this.UUIDArr.push(UUID + file.raw.size);
      let ossUrl = response.ossUrl;
      let filepath = response.filepath;
      this.fileUrlArr.push(filepath);
      //获取文件的名称
      let fileName = file.raw.name
      let fileType = file.raw.type
      let fileSize = file.raw.size
      let obj = {}
      obj.tableId = UUID + file.raw.size
      obj.fileName = fileName
      obj.fileType = fileType
      obj.fileSize = fileSize
      obj.tableType = this.type
      // obj.title = '打样申请文件'
      obj.tableName = "apvlFormula";
      obj.fileUrl = ossUrl
      if (obj.tableType === 1) {
        obj.title = '打样申请文件'
      } else if (obj.tableType === 2) {
        obj.title = '打样附件'
      }
      if (response.code === 1) {
        addManage(obj)
        this.$modal.msgSuccess('文件上传成功')
        if (this.type === 1) {
          this.forms.ossUrl1.push(obj.fileUrl)
        } else {
          this.forms.ossUrl2.push(obj.fileUrl)
        }
      } else {
        // 实现缩略图模板时删除文件
        let index = fileList.findIndex(fileItem => {
          return fileItem.uid === file.uid
        })
        fileList.splice(index, 1)
        this.$modal.msgError(response.msg)
      }
    },
    //文件上传失败钩子
    fileError(err, file, fileList) {
      this.$modal.msgError("文件上传失败，请联系管理员");
    },

    /**删除上传文件*/
    deleteFile(file, fileList) {
      let data = {}
      data.uuidList = this.UUIDArr
      data.filePaths = this.fileUrlArr;
      removeOssFile(data).then((response) => {
      });
    },
    fileRemove(file, fileList) {
      let arr = []
      let id = file.id
      let obj = {}
      obj.isDelete = 2
      obj.id = id
      arr.push(obj)
      this.handleRemove(file, fileList)
      updateFileManage(arr).then(response => {
        this.$modal.msgSuccess('删除文件成功')
      })
    },
    //打开上传文件控件方法
    fileUploadA(row, type) {

      this.temporaryPicture = []
      //显示
      this.fileUpload = true
      //行id
      this.tableId = row.id
      this.form.id = row.id
      let obj = {}
      obj.tableName = "apvlFormula";
      obj.tableId = this.tableId
      obj.isDelete = 1
      obj.tableType = type
      this.tableType = type
      //根据tableId和tableName 进行回显
      listManage(obj).then(response => {
        let rows = response.rows
        let fileList = []
        //控件值需要name 和 url 不然显示不了正确值
        for (let key in rows) {
          let obj1 = {}
          obj1.name = rows[key].fileName
          obj1.url = rows[key].fileUrl
          obj1.id = rows[key].id
          fileList.push(obj1)
        }
        this.fileList = fileList
      })
    },
    /** 查询打样申请单 包含申请单状态列表 */
    getList() {
      this.loading = true;
      listFormula(this.queryParams).then((response) => {
        this.formulaList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        apvlNo: null,
        formulataskNo: null,
        formulationType: null,
        customerId: null,
        customerName: null,
        brand: null,
        issueDate: null,
        samplingDate: null,
        formulaReq: null,
        seriesName: null,
        applSnrType: null,
        devTheme: null,
        erpCustomer: null,
        applSkinType: null,
        colorAndFlavor: null,
        formulaName: null,
        formulaUrl1: null,
        formulaUrl2: null,
        formulaUrl3: null,
        finishProductVolumes: null,
        containerType: null,
        productType: null,
        formulationNo: null,
        compatibilityTestReq: null,
        productFormulaReq: null,
        formulaVolumes: null,
        formulaQty: null,
        proposerId: null,
        proposer: null,
        proposeTime: null,
        attachmentUrl1: null,
        isUrgent: null,
        status: 0,
        note: null,
        idArr: [],
        creatorId: null,
        createTime: null,
        modifiedId: null,
        modifiedTime: null,
        fileName: null,
        fileType: null,
        fileUrl: null,
        originalFileName: null,
        fileSize: null,
        title: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加打样申请单 包含申请单状态";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getFormula(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改打样申请单 包含申请单状态";
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal
        .confirm(
          '是否确认删除打样申请单 包含申请单状态编号为"' + ids + '"的数据项？'
        )
        .then(function () {
          return delFormula(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {
        });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "admin/formula/export",
        {
          ...this.queryParams,
        },
        `formula_${new Date().getTime()}.xlsx`
      );
    },
    // 判断成品容量是否为正数可以是小数
    finishProductVolumeschange(value) {
      let reg = /^\d+(?=\.{0,1}\d+$|$)/
      if (!reg.test(value)) {
        this.$message.error('只能输入正整数或小数');
        this.form.finishProductVolumes = null
      }
    },
    // 判断内料单价是否为正数可以是小数
    interMaterialsPricechange(value) {
      let reg = /^\d+(?=\.{0,1}\d+$|$)/
      if (!reg.test(value)) {
        this.$message.error('只能输入正整数或小数');
        this.form.interMaterialsPrice = null
      }
    },
    // 判断样品容量是否为正数可以是小数
    formulaVolumeschange(value) {
      let reg = /^\d+(?=\.{0,1}\d+$|$)/
      if (!reg.test(value)) {
        this.$message.error('只能输入正整数或小数');
        this.form.formulaVolumes = null
      }
    },
    // 判断是否为正数可以是小数
    decimal(value) {
      let reg = /^\d+(?=\.{0,1}\d+$|$)/
      if (!reg.test(value)) {
        this.$message.error('只能输入正整数或小数');
      }
    },
    // 判断是否为正整数
    demo(value) {
      let reg = /^[1-9][0-9]*$/
      if (!reg.test(value)) {
        this.$message.error('请输入正整数');
        this.form.formulaQty = null
      }
    },
    //样品类型change
    formulaTypechange(val) {
      // console.log('val:',val);
      let obj = {}
      obj = this.dict.type.sys_formula_type.find((item) => { // 这里的provincelist就是上面省的数据
        return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
      })
      console.log('obj', obj) // 这个obj里面就是你想要的select中对应的数据
      this.forms.formulaType = obj.label
    },
    //样品剂型change
    formulaDosagechange(val) {
      // console.log('val:',val);
      let obj = {}
      obj = this.dict.type.sys_formula_dosage.find((item) => { // 这里的provincelist就是上面省的数据
        return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
      })
      // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
      this.forms.formulaDosage = obj.label
    },
    //开发背景change
    devBackgroundchange(val) {
      // console.log('val:',val);
      let obj = {}
      obj = this.dict.type.sys_dev_background.find((item) => { // 这里的provincelist就是上面省的数据
        return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
      })
      // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
      this.forms.devBackground = obj.label
    },
    //销售地区change
    salesDistrictchange(val) {
      if (val.indexOf('99') != -1) {
        this.salesDistrictStatus = true
        this.$set(this.form,'salesDistrictNote',null);
      } else {
        this.salesDistrictStatus = false
      }
    // let obj = {}
    // obj = this.dict.type.sys_sales_district.find((item) => { // 这里的provincelist就是上面省的数据
    //   return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    // })
    // // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    // this.forms.salesDistrict = obj.label
  },
  //打样类型change
  formulaMethodchange(val) {
    // console.log('val:',val);
    let obj = {}
    obj = this.dict.type.sys_formula_method.find((item) => { // 这里的provincelist就是上面省的数据
      return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    })
    // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    this.forms.formulaMethod = obj.label
  },
  //使用部位change
  usedPartchange(val) {
    // console.log('val:',val);
    let obj = {}
    obj = this.dict.type.sys_used_part.find((item) => { // 这里的provincelist就是上面省的数据
      return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    })
    // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    this.forms.usedPart = obj.label
  },
  // //成品单位change
  unitchange() {
    if (this.form.unit === '散装') {
      this.form.finishProductVolumes = ''
    }
  },
  //成品售价change
  erpCustomerchange(val) {
    // console.log('val:',val);
    let obj = {}
    obj = this.dict.type.sys_erp_customer.find((item) => { // 这里的provincelist就是上面省的数据
      return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    })
    // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    this.forms.erpCustomer = obj.label
  },
  //目标人群change
  applUserchange(val) {
    if (val !== 99) {
      this.form.applUserNote = null
    }
    // console.log('val:',val);
    let obj = {}
    obj = this.dict.type.sys_appl_user.find((item) => { // 这里的provincelist就是上面省的数据
      return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    })
    // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    this.forms.applUser = obj.label
  },
  //适用肌肤change
  applSkinTypechange(val) {
    if (val != 99) {
      this.form.applSkinTypeNote = null
    }
    // console.log('val:',val);
    let obj = {}
    obj = this.dict.type.sys_appl_skin_type.find((item) => { // 这里的provincelist就是上面省的数据
      return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    })
    // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    this.forms.applSkinType = obj.label
  },
  //颜色&香型change
  colorAndFlavorchange(val) {
    if (val !== '04') {
      this.form.colorAndFlavorNote = null
    }
    // console.log('val:',val);
    let obj = {}
    obj = this.dict.type.sys_color_and_flavor.find((item) => { // 这里的provincelist就是上面省的数据
      return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    })
    // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    this.forms.colorAndFlavor = obj.label
  },
  //容器类型change
  containerTypechange(val) {
    if (val != 99) {
      this.form.containerTypeNote = null
    }
    // console.log('val:',val);
    let obj = {}
    obj = this.dict.type.sys_container_type.find((item) => { // 这里的provincelist就是上面省的数据
      return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    })
    // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    this.forms.containerType = obj.label
  },
  //样品包装方式change
  packingchange(val) {
    // console.log('val:',val);
    let obj = {}
    obj = this.dict.type.sys_packing.find((item) => { // 这里的provincelist就是上面省的数据
      return item.value === val // 筛选出匹配数据，这里的id是接口数据中的每一项的id
    })
    // console.log('obj',obj) // 这个obj里面就是你想要的select中对应的数据
    this.forms.packing = obj.label
  },
  //预览弹框取消页面
  previewcancel() {
    this.preview = false
    this.forms.usedEfficacyReqlist = null
    this.forms.specificaReqlist = null
    this.forms.salesChannelList = null
    this.forms.finishProductVolumes = null
    this.forms = {}
  },
  //预览按钮操作
  previewclick() {
    console.log(this.form)
    console.log(this.forms)
    this.forms = {}
    let myDate = new Date()
    let date = myDate.getFullYear() + '-' + (myDate.getMonth() + 1) + '-' + myDate.getDate()
    this.forms.date = date
    this.forms.note = this.form.note
    this.forms.customerCode = this.form.customerCode
    this.forms.customerName = this.form.customerName
    this.forms.itemName = this.form.itemName
    this.forms.brand = this.form.brand
    this.forms.samplingDate = this.form.samplingDate
    if (this.form.formulaType) {
      let formulaType = {}
      formulaType = this.dict.type.sys_formula_type.find((item) => {
        return item.value === this.form.formulaType
      })
      this.forms.formulaType = formulaType.label
    }


    if (this.form.formulaDosage) {
      let formulaDosage = {}
      formulaDosage = this.dict.type.sys_formula_dosage.find((item) => {
        return item.value === this.form.formulaDosage
      })
      this.forms.formulaDosage = formulaDosage.label
    }


    if (this.form.devBackground) {
      let devBackground = {}
      devBackground = this.dict.type.sys_dev_background.find((item) => {
        return item.value === this.form.devBackground
      })
      this.forms.devBackground = devBackground.label
    }



    // if (this.form.salesDistrict) {
    //   let salesDistrict = {}
    //   salesDistrict = this.dict.type.sys_sales_district.find((item) => {
    //     return item.value === this.form.salesDistrict
    //   })
    //   this.forms.salesDistrict = salesDistrict.label
    // }

    if (this.salesDistrictList.length == 1 && !this.forms.salesDistrictList) {
      console.log('salesDistrictList', this.salesDistrictList)
      let a = this.dict.type.sys_sales_district
      for (let i in a) {
        console.log(a[i])
        if (a[i].value == this.salesChannelList[0]) {
          this.forms.salesDistrictList = a[i].label
        }
      }
    } else if (this.salesDistrictList.length > 1) {
      console.log('salesDistrictList', this.salesDistrictList)
      let a = this.dict.type.sys_sales_district
      for (let j in this.salesDistrictList) {
        for (let i in a) {
          if (this.salesDistrictList[j] == a[i].value && !this.forms.salesDistrictList) {
            this.forms.salesDistrictList = a[i].label
          } else if (this.salesDistrictList[j] == a[i].value) {
            this.forms.salesDistrictList = this.forms.salesDistrictList + ',' + a[i].label
          }
        }
      }
    }


    if (this.form.formulaMethod) {
      let formulaMethod = {}
      formulaMethod = this.dict.type.sys_formula_method.find((item) => {
        return item.value === this.form.formulaMethod
      })
      this.forms.formulaMethod = formulaMethod.label
    }


    if (this.form.usedPart) {
      let usedPart = {}
      usedPart = this.dict.type.sys_used_part.find((item) => {
        return item.value === this.form.usedPart
      })
      this.forms.usedPart = usedPart.label
    }


    if (this.form.erpCustomer) {
      let erpCustomer = {}
      erpCustomer = this.dict.type.sys_erp_customer.find((item) => {
        return item.value === this.form.erpCustomer
      })
      this.forms.erpCustomer = erpCustomer.label
    }


    if (this.form.applUser) {
      let applUser = {}
      applUser = this.dict.type.sys_appl_user.find((item) => {
        return item.value === this.form.applUser
      })
      this.forms.applUser = applUser.label
    }


    if (this.form.applSkinType) {
      let applSkinType = {}
      applSkinType = this.dict.type.sys_appl_skin_type.find((item) => {
        return item.value === this.form.applSkinType
      })
      this.forms.applSkinType = applSkinType.label
    }


    if (this.form.colorAndFlavor) {
      let colorAndFlavor = {}
      colorAndFlavor = this.dict.type.sys_color_and_flavor.find((item) => {
        return item.value === this.form.colorAndFlavor
      })
      this.forms.colorAndFlavor = colorAndFlavor.label
    }


    if (this.form.containerType) {
      let containerType = {}
      containerType = this.dict.type.sys_container_type.find((item) => {
        return item.value === this.form.containerType
      })
      this.forms.containerType = containerType.label
    }


    if (this.form.packing) {
      let packing = {}
      packing = this.dict.type.sys_packing.find((item) => {
        return item.value === this.form.packing
      })
      this.forms.packing = packing.label
    }


    if (this.form.interMaterialsPrice) {
      this.forms.interMaterialsPrice = this.form.interMaterialsPrice + '元/KG'
    }
    if (this.form.formulaQty && this.form.formulaVolumes) {
      this.forms.formulaQty = this.form.formulaVolumes + 'G*' + this.form.formulaQty + 'PCS'
    }
    for (let i in this.usedEfficacyReqlist) {
      for (let j in this.usedEfficacyReqlists) {
        if (this.usedEfficacyReqlist[i] == this.usedEfficacyReqlists[j].value && !this.forms.usedEfficacyReqlist) {
          this.forms.usedEfficacyReqlist = this.usedEfficacyReqlists[j].name
        } else if (this.usedEfficacyReqlist[i] == this.usedEfficacyReqlists[j].value) {
          this.forms.usedEfficacyReqlist = this.forms.usedEfficacyReqlist + ',' + this.usedEfficacyReqlists[j].name
        }
      }
    }
    for (let i in this.specificaReqlist) {
      for (let j in this.specificaReqlists) {
        if (this.specificaReqlist[i] == this.specificaReqlists[j].value && !this.forms.specificaReqlist) {
          this.forms.specificaReqlist = this.specificaReqlists[j].name
        } else if (this.specificaReqlist[i] == this.specificaReqlists[j].value) {
          this.forms.specificaReqlist = this.forms.specificaReqlist + ',' + this.specificaReqlists[j].name
        }
      }
    }
    if (this.salesChannelList.length == 1 && !this.forms.salesChannelList) {
      let a = this.dict.type.sys_sales_channel
      for (let i in a) {
        console.log(a[i])
        if (a[i].value == this.salesChannelList[0]) {
          this.forms.salesChannelList = a[i].label
        }
      }
    } else if (this.salesChannelList.length > 1) {
      let a = this.dict.type.sys_sales_channel
      for (let j in this.salesChannelList) {
        for (let i in a) {
          if (this.salesChannelList[j] == a[i].value && !this.forms.salesChannelList) {
            this.forms.salesChannelList = a[i].label
          } else if (this.salesChannelList[j] == a[i].value) {
            this.forms.salesChannelList = this.forms.salesChannelList + ',' + a[i].label
          }
        }
      }
    }
    if (this.forms.salesDistrict == '其他') {
      this.forms.salesDistrict = this.form.salesDistrictNote
    }
    if (this.forms.applUser == '其他') {
      this.forms.applUser = this.form.applUserNote
    }
    if (this.forms.applSkinType == '其他') {
      this.forms.applSkinType = this.form.applSkinTypeNote
    }
    if (this.forms.colorAndFlavor == '客户指定') {
      this.forms.colorAndFlavor = this.form.colorAndFlavorNote
    }
    if (this.forms.containerType == '其他') {
      this.forms.containerType = this.form.containerTypeNote
    }
    if (this.form.unit) {
      if (this.form.unit == "散装") {
        this.forms.finishProductVolumes = this.form.unit
      } else {
        if (this.form.finishProductVolumes)
          this.forms.finishProductVolumes = this.form.finishProductVolumes + this.form.unit
      }
    }
    // if (this.form.samplingDate){
    //   let d = this.form.samplingDate;
    //   let datetime=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() ;
    //   this.forms.samplingDate = datetime
    // }
    this.forms.samplingDate = this.form.samplingDate
    if (this.form.nickName) {
      let a = this.form.nickName;
      let b = ''
      for (let i in a) {
        if (i == 0) {
          b = a[i]
        } else {
          b = b + ',' + a[i]
        }
      }
      this.forms.nickName = b
    }
    if (this.forms.ossUrl1) {
      let a = this.forms.ossUrl1;
      let b = ''
      for (let i in a) {
        if (i == 0) {
          b = a[i]
        } else {
          b = b + ',' + a[i]
        }
      }
      this.forms.ossUrl1s = b
    }
    if (this.forms.ossUrl2) {
      let a = this.forms.ossUrl2;
      let b = ''
      for (let i in a) {
        if (i == 0) {
          b = a[i]
        } else {
          b = b + ',' + a[i]
        }
      }
      this.forms.ossUrl2s = b
    }
    this.preview = true
  }
}
,

}
;
</script>
<style lang="scss" scoped>
body,
html {
  height: 100%;
  overflow: auto;
}

::v-deep .v-modal {
  position: unset;
}

//.el-row {
//  margin-bottom: 20px;
//
//  &:last-child {
//    margin-bottom: 0;
//  }
//}

.el-col {
  border-radius: 4px;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.titles {
  margin: 2%;
  cursor: pointer;
}

.popup-ui {
  margin-left: -40px;
  margin-top: -10px;
  //padding-top: 0;
  //margin-top: -7%;
}

.formula {
  width: 100%;

  .formula-center {
    // width: 160%;
    //margin-left: 10%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    // flex-wrap: nowrap;
    // align-content: baseline;
  }

  .formula-li {
    margin-top: -10px;
  }

  .textarea-li {
    width: 180%;
    margin-top: 14px;
  }


  // ::v-deep .popup-ui label{
  //   // margin-left: -40%;
  // 	width: 50px !important;
  // }

  .formula-liul {
    margin-top: -10px;
    display: flex;
    // justify-content: space-between;
  }

  ::v-deep .el-input {
    //width: 220px;
    width: 13vw;
  }

  .formula-dialog-button {
    width: 70%;
    display: flex;
    justify-content: space-between;
    padding: 4% 10% 10% 20%;
  }

  ::v-deep .el-popup-parent--hidden {
    overflow: unset;
  }

  ::v-deep .el-upload-dragger {
    width: 220px;
    height: 54px;
    border: none;
    margin-top: -8px;

    > button {
      margin-top: 2%;
    }
  }
}

.checkboxlist {
  // margin: 0 15% 0 3%;
}

.checkboxlists label {
  // margin: 0 15% 0 3%;
  width: 55px;
}

.checkboxlists label:nth-child(32) {
  // margin: 0 15% 0 3%;
  width: 85px;
}

::v-deep .selectss .el-input {
  width: 100px !important;
}

.previewtab table {
  width: 100%;
}

.previewtab table {
  border-collapse: collapse;
}

.previewtab table, th, td {
  border: 1px solid #000000;
}

.previewtab td {
  width: 25%;
  padding: 1% 0 1% 1%;
}
</style>
