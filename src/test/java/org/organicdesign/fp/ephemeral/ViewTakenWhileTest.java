// Copyright (c) 2014-04-13 PlanBase Inc. & Glen Peterson
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.organicdesign.fp.ephemeral;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.organicdesign.fp.function.Function1;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnit4.class)
public class ViewTakenWhileTest {

    @Test
    public void takeItemsInOneBatch() {
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9)
                              .takeWhile(Function1.accept()).toArray());

        assertArrayEquals(new Integer[] { 1,2,3,4,5,6,7,8,9 },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i < 10).toArray());

        assertArrayEquals(new Integer[] { 1,2,3,4,5,6,7,8,9 },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i <= 9).toArray());

        assertArrayEquals(new Integer[] { 1,2,3,4,5,6,7,8 },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i <= 8).toArray());

        assertArrayEquals(new Integer[] { 1,2,3,4,5,6,7 },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i <= 7).toArray());

        assertArrayEquals(new Integer[] { 1,2,3 },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i <= 3).toArray());

        assertArrayEquals(new Integer[] { 1,2 },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i <= 2).toArray());

        assertArrayEquals(new Integer[] { 1 },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i <= 1).toArray());

        assertArrayEquals(new Integer[] {  },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(Function1.reject())
                                  .toArray());

        assertArrayEquals(new Integer[] {  },
                          View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i > 10).toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception1() { View.ofArray(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(null); }
}
