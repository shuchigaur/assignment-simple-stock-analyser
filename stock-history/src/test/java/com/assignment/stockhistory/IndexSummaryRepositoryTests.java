/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.assignment.stockhistory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IndexSummaryRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IndexSummaryRepository indexSummaryRepository;

    private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    private static Date startDate;
    private static Date endDate;

    @BeforeClass
    public static void setUp() throws ParseException {
        startDate = sdf.get().parse("2013-12-10");
        endDate = sdf.get().parse("2018-12-10");
    }

    @Test
    public void testFindByIndexDateBetween() {

        List<IndexSummary> findByIndexDateBetween =
                indexSummaryRepository.findByDateBetween(startDate, endDate);
        assertThat(findByIndexDateBetween.size()).isEqualTo(2492);
    }

    @Test
    public void testFindByTypeAndDateBetween_BSE() {

        List<IndexSummary> findByIndexDateBetween =
                indexSummaryRepository.findByTypeAndDateBetween("BSE", startDate, endDate);
        assertThat(findByIndexDateBetween.size()).isEqualTo(1234);
    }

    @Test
    public void testFindByTypeAndDateBetween_DJI() {

        List<IndexSummary> findByIndexDateBetween =
                indexSummaryRepository.findByTypeAndDateBetween("DJI", startDate, endDate);
        assertThat(findByIndexDateBetween.size()).isEqualTo(1258);
    }
}