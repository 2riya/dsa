Following is the representation of how merge sort works:

<img src="//upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Merge_sort_algorithm_diagram.svg/300px-Merge_sort_algorithm_diagram.svg.png" decoding="async" width="300" height="289" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Merge_sort_algorithm_diagram.svg/450px-Merge_sort_algorithm_diagram.svg.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Merge_sort_algorithm_diagram.svg/600px-Merge_sort_algorithm_diagram.svg.png 2x" data-file-width="618" data-file-height="595" alt="alt:merge-sort-representation">

<br>
<br>1. Find middle element of array and break the element into 2 halves, left to mid and mid + 1 to right
<br>2. Recursively call merge sort for both the halves (shown in red), until only a single element is present the array being considered (shown in grey)
<br>3. After that keep merging the sorted arrays until full array is obtained (shown in green)
<br>
<br>
<b>Pseudocode:</b>
<br> 1. l = 0, r = arr.length
<br> 2. mid = (l + r)/2
<br> 3. mergeSort(l, mid)
<br> 4. mergeSort(mid + 1, r)
<br> 5. merge(l, r)
<br> 6. Do this until l < r
<br>
<br><b>Pseudocode for Merge:</b> 
<br> 1. leftArr = store nums[l to mid]
<br> 2. rightArr = store nums[mid + 1 to r]
<br> 3. i = l, j = mid + 1,k = l
<br> 4. while i < mid && j < r, do:
<br> 5. if (leftArr[i] < rightArr[j]) nums[k] = leftArr[i], i++
<br> 6. else nums[k] = rightArr[j], j++
<br> 7. end while loop
<br> 8. if elements in leftArr are remaining add them to nums
<br> 9. if elements in rightArr are remaining add them to nums
