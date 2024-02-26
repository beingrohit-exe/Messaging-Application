/*
 * Copyright © 2023-2024 Rohit Parihar and Bloggios
 * All rights reserved.
 * This software is the property of Rohit Parihar and is protected by copyright law.
 * The software, including its source code, documentation, and associated files, may not be used, copied, modified, distributed, or sublicensed without the express written consent of Rohit Parihar.
 * For licensing and usage inquiries, please contact Rohit Parihar at rohitparih@gmail.com, or you can also contact support@bloggios.com.
 * This software is provided as-is, and no warranties or guarantees are made regarding its fitness for any particular purpose or compatibility with any specific technology.
 * For license information and terms of use, please refer to the accompanying LICENSE file or visit http://www.apache.org/licenses/LICENSE-2.0.
 * Unauthorized use of this software may result in legal action and liability for damages.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.messaging.application.configuration;

import lombok.SneakyThrows;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.HttpHeaders;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - auth-provider-read-service
 * Package - com.bloggios.auth.provider.read.configuration
 * Created_on - 02 December-2023
 * Created_at - 13 : 26
 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.messaging.application.dao")
@ComponentScan(basePackages = "com.messaging.application")
public class ElasticClientConfiguration extends AbstractElasticsearchConfiguration {

    @Override
    @Bean(destroyMethod = "close")
    @SneakyThrows
    public RestHighLevelClient elasticsearchClient() {
        HttpHeaders compatibilityHeaders = new HttpHeaders();
        compatibilityHeaders.add("Accept", "application/vnd.elasticsearch+json;compatible-with=7");
        compatibilityHeaders.add("Content-Type", "application/vnd.elasticsearch+json;"
                + "compatible-with=7");
        ClientConfiguration clientConfiguration = ClientConfiguration
                .builder()
                .connectedTo("localhost:9200")

                .withBasicAuth("elastic", "_ZY1*zREiWDKkFDYKtxB")
                .withDefaultHeaders(compatibilityHeaders)
                .build();
        return RestClients
                .create(clientConfiguration)
                .rest();
    }

    @Bean
    public ElasticsearchOperations template() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}
