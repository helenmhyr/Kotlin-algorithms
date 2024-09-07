fun main() {
    fun firstNonRepeating(s: String): Int {
        if (s.isEmpty()) return -1
        val map = hashMapOf<Char, Int>()
        s.forEach { map[it] = map.getOrDefault(it, 0) + 1 }

        for (i in s.indices) {
            if (map[s[i]] == 1) {
                return i
            }
        }
        return -1
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size
        while (l <= r) {
            val mid = (l + r) / 2
            when {
                target < nums[mid] -> r = mid - 1
                target > nums[mid] -> l = mid + 1
                nums[mid] == target -> return mid
            }
        }
        return l
    }

    fun isPalindrome(x: Int): Boolean {
        return x.toString() == x.toString().reversed()
    }

    fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
        var acount = 0
        var bcount = 0
        a.forEachIndexed { index, value ->
            if (value > b[index]) {
                acount += 1
            } else if (value < b[index]) {
                bcount += 1
            }
        }
        return arrayOf(acount, bcount)
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val diffMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, int ->
            diffMap[int]?.let {
                println(it)
                return intArrayOf(it, index)
            }
            diffMap[target - int] = index
        }
        return intArrayOf()
    }

    fun longestCommonPrefix(ar: Array<String>) = StringBuilder().apply {
        ar.minByOrNull { it.length }
            ?.forEachIndexed { index, value -> if (ar.all { it[index] == value }) append(value) else return toString() }
    }.toString()

    fun insertEle(arr: IntArray, y: Int, yIndex: Int) {
        if (arr.size >= yIndex - 1) {
            arr[yIndex] = y
            println(arr.joinToString(" "))
        }
    }

    fun deleteEle(arr: IntArray, y: Int): List<Int> {
        return arr.filter { it != y }
    }

    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if(head?.next == null) {
            return head
        }
        var h = head
        while (h?.next != null) {
            if(h.value == h.next!!.value) {
                h.next = h.next!!.next
            } else{
                h = h.next
            }
        }
        return head
    }
}