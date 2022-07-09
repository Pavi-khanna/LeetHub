# Stock span problem
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px"><nr-sentence class="nr-s0" id="nr-s0" page="0">The stock span problem is a financial problem where we have a series of </nr-sentence><strong><nr-sentence class="nr-s0" id="nr-s0" page="0">n</nr-sentence></strong><nr-sentence class="nr-s0" id="nr-s0" page="0"> daily price quotes for a stock and we need to calculate the span of stocks price for all </nr-sentence><strong><nr-sentence class="nr-s0" id="nr-s0" page="0">n</nr-sentence></strong><nr-sentence class="nr-s0" id="nr-s0" page="0"> days.</nr-sentence>&nbsp;<br><nr-sentence class="nr-s1" id="nr-s1" page="0">
The span </nr-sentence><strong><nr-sentence class="nr-s1" id="nr-s1" page="0">S</nr-sentence><sub><nr-sentence class="nr-s1" id="nr-s1" page="0">i</nr-sentence></sub></strong><nr-sentence class="nr-s1" id="nr-s1" page="0"> of the stocks price on a given day </nr-sentence><strong><nr-sentence class="nr-s1" id="nr-s1" page="0">i</nr-sentence></strong><nr-sentence class="nr-s1" id="nr-s1" page="0"> is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.</nr-sentence><br><nr-sentence class="nr-s2" id="nr-s2" page="0">
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.</nr-sentence></span></p>

<p><span style="font-size:18px"><strong><nr-sentence class="nr-s3" id="nr-s3" page="0">Example 1:</nr-sentence></strong></span></p>

<pre><span style="font-size:18px"><strong><nr-sentence class="nr-s4" id="nr-s4" page="0">Input</nr-sentence></strong><nr-sentence class="nr-s4" id="nr-s4" page="0">:</nr-sentence> <nr-sentence class="nr-selected-post nr-s5" id="nr-s5" page="0">
N = 7, price[] = [100 80 60 70 60 75</nr-sentence><nr-sentence class="nr-s6" id="nr-s6" page="0"> 85]
</nr-sentence><strong><nr-sentence class="nr-s6" id="nr-s6" page="0">Output</nr-sentence></strong><nr-sentence class="nr-s6" id="nr-s6" page="0">:
1 1 1 2 1 4 6
</nr-sentence><strong><nr-sentence class="nr-s6" id="nr-s6" page="0">Explanation</nr-sentence></strong><nr-sentence class="nr-s6" id="nr-s6" page="0">:
Traversing the given input span for&nbsp;100 
will be 1, 80 is smaller than 100 so the 
span is 1, 60 is smaller than 80 so the 
span is 1, 70 is greater than 60 so the 
span is 2 and so on.</nr-sentence><nr-sentence class="nr-s7" id="nr-s7" page="0"> Hence the output will 
be 1 1 1 2 1 4 6.</nr-sentence>
</span></pre>

<p><span style="font-size:18px"><strong><nr-sentence class="nr-s8" id="nr-s8" page="0">Example 2:</nr-sentence></strong></span></p>

<pre><span style="font-size:18px"><strong><nr-sentence class="nr-s9" id="nr-s9" page="0">Input</nr-sentence></strong><nr-sentence class="nr-s9" id="nr-s9" page="0">: 
N = 6, price[] = [10 4 5 90 120 80]
</nr-sentence><strong><nr-sentence class="nr-s9" id="nr-s9" page="0">Output</nr-sentence></strong><nr-sentence class="nr-s9" id="nr-s9" page="0">:
1 1 2 4 5 1
</nr-sentence><strong><nr-sentence class="nr-s9" id="nr-s9" page="0">Explanation</nr-sentence></strong><nr-sentence class="nr-s9" id="nr-s9" page="0">:
Traversing the given input span for 10 
will be 1, 4 is smaller than 10 so the 
span will be 1, 5 is greater than 4 so 
the span will be 2 and so on.</nr-sentence><nr-sentence class="nr-s10" id="nr-s10" page="0"> Hence, the 
output will be&nbsp;1 1 2 4 5 1.</nr-sentence></span></pre>

<p><span style="font-size:18px"><strong><nr-sentence class="nr-s11" id="nr-s11" page="0">User Task:</nr-sentence></strong><br><nr-sentence class="nr-s11" id="nr-s11" page="0">
The task is to complete the function&nbsp;</nr-sentence><strong><nr-sentence class="nr-s11" id="nr-s11" page="0">calculateSpan</nr-sentence></strong><nr-sentence class="nr-s11" id="nr-s11" page="0">() which takes two parameters, an array</nr-sentence><strong><nr-sentence class="nr-s11" id="nr-s11" page="0"> price[] </nr-sentence></strong><nr-sentence class="nr-s11" id="nr-s11" page="0">denoting the price of stocks, and an integer </nr-sentence><strong><nr-sentence class="nr-s11" id="nr-s11" page="0">N </nr-sentence></strong><nr-sentence class="nr-s11" id="nr-s11" page="0">denoting the size of the array and number of days.</nr-sentence><nr-sentence class="nr-s12" id="nr-s12" page="0"> This function finds the span of stock's price for all N&nbsp;days and returns an array of length </nr-sentence><strong><nr-sentence class="nr-s12" id="nr-s12" page="0">N</nr-sentence></strong><nr-sentence class="nr-s12" id="nr-s12" page="0"> denoting the span for the i-th day.</nr-sentence></span></p>

<p><span style="font-size:18px"><strong><nr-sentence class="nr-s13" id="nr-s13" page="0">Expected Time Complexity:&nbsp;</nr-sentence></strong><nr-sentence class="nr-s13" id="nr-s13" page="0">O(N).</nr-sentence><br>
<strong><nr-sentence class="nr-s14" id="nr-s14" page="0">Expected Auxiliary Space:&nbsp;</nr-sentence></strong><nr-sentence class="nr-s14" id="nr-s14" page="0">O(N).</nr-sentence></span></p>

<p><span style="font-size:18px"><strong><nr-sentence class="nr-s15" id="nr-s15" page="0">Constraints:</nr-sentence></strong><br><nr-sentence class="nr-s15" id="nr-s15" page="0">
1 ≤ N ≤ 10</nr-sentence><sup><nr-sentence class="nr-s15" id="nr-s15" page="0">5</nr-sentence></sup><br><nr-sentence class="nr-s15" id="nr-s15" page="0">
1 ≤ C[i] ≤ 10</nr-sentence><sup><nr-sentence class="nr-s15" id="nr-s15" page="0">5</nr-sentence></sup></span></p>

<p><span style="font-size:18px"><img alt="" src="https://contribute.geeksforgeeks.org/wp-content/uploads/Stock_span.png" class="img-responsive"></span></p>
 <p></p>
            </div>