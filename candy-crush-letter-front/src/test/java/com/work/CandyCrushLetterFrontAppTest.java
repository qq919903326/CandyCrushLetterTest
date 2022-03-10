package com.work;

import com.work.handle.StringAlgorithmHandler;
import org.junit.jupiter.api.Test;

class CandyCrushLetterFrontAppTest {
    @Test
    public void oneTest() {
        System.out.println(StringAlgorithmHandler.rmDuplicates("aabcccbbad",3).get());
    }
    @Test
    public void twoTest() {
        System.out.println(StringAlgorithmHandler.replacedDuplicates("aabcccbbad",3).get());
    }
}