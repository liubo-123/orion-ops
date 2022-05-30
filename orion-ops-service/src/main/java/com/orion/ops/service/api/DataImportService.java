package com.orion.ops.service.api;

import com.orion.ops.consts.export.ImportType;
import com.orion.ops.entity.dto.DataImportDTO;
import com.orion.ops.entity.dto.MachineInfoImportDTO;
import com.orion.ops.entity.vo.DataImportCheckVO;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * 数据导入服务
 *
 * @author Jiahang Li
 * @version 1.0.0
 * @since 2022/5/26 17:06
 */
public interface DataImportService {

    /**
     * 解析导入 workbook
     *
     * @param workbook workbook
     * @param type     type
     * @param <T>      T
     * @return list
     */
    <T> List<T> parseImportWorkbook(ImportType type, Workbook workbook);

    /**
     * 检查机器导入信息
     *
     * @param rows rows
     * @return 导入信息
     */
    DataImportCheckVO checkMachineImportData(List<MachineInfoImportDTO> rows);

    /**
     * 检查导入 token
     *
     * @param token token
     * @return 导入数据
     */
    DataImportDTO checkImportToken(String token);

    /**
     * 导入机器信息
     *
     * @param checkData 缓存信息
     */
    void importMachineData(DataImportDTO checkData);

    /**
     * 清空导入 token
     *
     * @param token token
     */
    void clearImportToken(String token);

}