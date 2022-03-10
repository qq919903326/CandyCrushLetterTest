package com.work;

import com.work.handle.StringAlgorithmHandler;
import org.junit.jupiter.api.Test;

class CandyCrushLetterFrontAppTest {
    @Test
    public void test() {
        System.out.println(StringAlgorithmHandler.rmDuplicates("aabcccbbad",3));
    }
}