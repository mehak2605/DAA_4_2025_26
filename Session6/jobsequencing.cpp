#include <vector>
#include <stdio.h>
#include <utility>
#include <iostream>
#include <algorithm>
using namespace std;
class jobsequencing
{
    public:
    static bool cmp(pair <int, int> a, pair <int, int> b)
    {
        if(a.first>b.first)
        return true;
        else
        return false;
    }
    static int maxDeadline(vector <pair<int, int>> vec)
    {
        int i=0;
        int max=0;
        while(i<vec.size())
        {
            if(vec[i].second>max)
            max=vec[i].second;
            i++;
        }
        return max;
    }
    static int find(int next[], int n)
    {
        if(next[n]==n)
        return n;
        return next[n]=find(next, next[n]);
    }
    static vector<int> jobSequencing(vector<int> &deadline, vector<int> &profit) {
        // code here
        int n=deadline.size();  
        vector <pair<int, int>> vec;
        int p=0, d=0;
        for(int i=0; i<n; i++)
        {
            vec.push_back(make_pair(profit[i], deadline[i]));
        }
        std::sort(vec.begin(), vec.end(), cmp);
        int maxTime=maxDeadline(vec);
        //int slot[maxTime+1] = {0};
        int next[maxTime+1];
        for(int i=0; i<=maxTime; i++)
        next[i]=i;
        int dl=0, sum=0, c=0;
        for(int i=0; i<n; i++)  //for jobs
        {
            int index=find(next, vec[i].second);
            if(index>0)
            {
                sum+=vec[i].first;
                c++;                
                next[index]=find(next, index-1);
            }
        }
        vector <int> ans;
        ans.push_back(c);
        ans.push_back(sum);
        return ans;
    }
};
int main()
{
    int n;
    cout << "Enter the number of jobs: ";
    cin >> n;
    vector <int> profit;
    vector <int> time;
    int p, t;
    cout << "Enter profit and deadlines: \n";
    for(int i=0; i<n; i++)
    {
        cin >> p;
        cin >> t;
        profit.push_back(p);
        time.push_back(t);
    }
    jobsequencing obj;
    vector <int> ans = obj.jobSequencing(time, profit);
    cout << "Nunber of jobs done = " << ans[0] <<endl;
    cout << "Profit generated = " << ans[1] <<endl;
}