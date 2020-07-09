package org.example.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

public class DruidDSFactory extends PooledDataSourceFactory {

    public DruidDSFactory() {
        this.dataSource = new DruidDataSource();//替换数据源
    }
}
