
# [Valid Palindrome IV](https://leetcode.com/problems/valid-palindrome-iv) ![](https://img.shields.io/badge/Medium-orange)

<p>You are given a <strong>0-indexed</strong> string <code>s</code> consisting of only lowercase English letters. In one operation, you can change <strong>any</strong> character of <code>s</code> to any <strong>other</strong> character.</p>

<p>Return <code>true</code><em> if you can make </em><code>s</code><em> a palindrome after performing <strong>exactly</strong> one or two operations, or return </em><code>false</code><em> otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcdba&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> One way to make s a palindrome using 1 operation is:
- Change s[2] to &#39;d&#39;. Now, s = &quot;abddba&quot;.
One operation could be performed to make s a palindrome so return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> One way to make s a palindrome using 2 operations is:
- Change s[0] to &#39;b&#39;. Now, s = &quot;ba&quot;.
- Change s[1] to &#39;b&#39;. Now, s = &quot;bb&quot;.
Two operations could be performed to make s a palindrome so return true.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcdef&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> It is not possible to make s a palindrome using one or two operations so return false.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>

        