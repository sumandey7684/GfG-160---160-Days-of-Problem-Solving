class Solution {
public:
    const int MAX_CHAR = 26;

    string getHash(string &s) {
        string hash;
        vector<int> freq(MAX_CHAR, 0);
        for (char ch : s) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < MAX_CHAR; i++) {
            hash.append(to_string(freq[i]));
            hash.append("$");
        }
        return hash;
    }

    vector<vector<string>> anagrams(vector<string>& arr) {
        vector<vector<string>> res;
        unordered_map<string, int> mp;

        for (int i = 0; i < arr.size(); i++) {
            string key = getHash(arr[i]);
            if (mp.find(key) == mp.end()) {
                mp[key] = res.size();
                res.push_back({});
            }
            res[mp[key]].push_back(arr[i]);
        }

        return res;
    }
};
