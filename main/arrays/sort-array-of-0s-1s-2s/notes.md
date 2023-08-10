There are only 3 digits - 0's, 1's and 2's <br>
Intuitively we can think that if we move all zeroes to front and all 2's to end, 1's would remain sorted only in the center.
<br>
To achieve this, implemented following also using hit-and-trial.
<br>

Steps:
<br> 1. Set leftPtr = 0 
<br> 2. For i = leftPtr to end, for each 0 found, swap it with element at leftPtr and increment leftPtr by 1 
<br> 3. From end of array, find first non-2 element, this index will be rightPtr
<br> 4. For i = leftPtr to rightPtr, for each 2 found, swap it with element at rightPtr, decrement rightPtr until a non-2 element is found

<br>
<hr>

Using **Dutch National Flag Algorithm** -
<br> Consider three groups:
<br> 0 to low - 1 : All 0's will be here
<br> low to mid - 1 : All 1's will be here
<br> hi + 1 to end : All 2's will be here

<pre>
0 .... low - 1 low .... mid-1 mid .... hi hi + 1 .... end
   0 0 0 0 0    1 1 1 1 1 1     0 2 1 0      2 2 2 2 2 
</pre>

=> From 0 to <code>mid - 1</code> and from <code>hi + 1</code> to end, out array will be sorted. 
<br>Only <code>mid</code> to <code>hi</code>, we need to sort.

<br> Starting from <code>mid</code>, let's analyze the cases -
<br> 
<br> <b>Case 1: arr[mid] == 0</b>
<br> It should be in the first group
<br> Swap it with low and increment low
<pre>
0 .... low - 1 low .... mid-1  mid .... hi hi + 1 .... end
   0 0 0 0      0  1 1 1 1 1     1 2 1 0      2 2 2 2 2 
               __               __
</pre>
0 came besides other zeroes, and it was replaced by element at <code>low</code>, from where group of 1's start.
<br> Therefore, 1 present at <code>low</code> would go to the end of it's group
<br> Hence, we'll increment both <code>low</code> and <code>mid</code>
<pre>
swap(arr[idx], arr[low])
mid++;
low++;
</pre>

<br> <b>Case 2: arr[mid] == 1</b>
<br> It's already besides group of 1's present between <code>low</code> to <code>mid - 1</code>
<br> So simply increment <code>mid</code> 
<pre>
mid++;
</pre>

<br><b>Case 3: arr[mid] == 2</b> 
<br> 2 should be moved along with other 2's present between <code>hi + 1</code> to <code>end</code>
<br> Swap this 2 with element at <code>hi</code>, and decrement <code>hi</code>
<pre>
0 .... low - 1 low .... mid-1 mid .... hi hi + 1 .... end
   0 0 0 0 0    1 1 1 1 1 1     2 2 1 0      2 2 2 2 2 
                               --     -- 

0 .... low - 1 low .... mid-1 mid .... hi hi + 1 .... end
   0 0 0 0 0    1 1 1 1 1 1     0  2  1       2 2 2 2 2 2
</pre>

2 comes besides the group of other 2's, making <code>hi</code> to <code>end</code> sorted
<br> Therefore, we'll decrement <code>hi</code> and keep <code>mid</code> as is, since element at <code>mid</code> is still a part of unsorted sequence
<pre>
swap(arr[mid], arr[hi])
hi--;
</pre>

<br> <br>
<b>Pseudocode:</b>
<br>Since <code>mid</code> to <code>hi</code>, is unsorted seq,
<br>Algorithm will start considering <code>mid</code> as 0 and <code>hi</code> as <code>end</code>
<br>Because we'll assume initially entire array is unsorted
<pre>
mid = 0;
lo = 0;
hi = end;

while (mid <= hi) 
    case 1: 
        swap(mid, low)
        low++;
        mid++;
    case 2:
        mid++;
    case 3:
        swap(mid, hi)
        hi--;
</pre>
