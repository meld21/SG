
var populationData = {person1 : {"birthYear" : 1981, "deathYear": 1999}, 
                      person2 : {birthYear : 1920, "deathYear" : 1991},
                      person3 : {birthYear : 1901, "deathYear" : 1956},
                      person4 : {birthYear : 1973, "deathYear" : 2000},
                      person5 : {birthYear : 1946, "deathYear" : 1983},
                      person6 : {birthYear : 1955, "deathYear" : 1960},
                      person7 : {birthYear : 1963, "deathYear" : 1992},
                      person8 : {birthYear : 1982, "deathYear" : 1997},
                      person9 : {birthYear : 1949, "deathYear" : 1988},
                      person10 : {birthYear : 1913, "deathYear" : 1965},
                      person11 : {birthYear : 1922, "deathYear" : 1979}};

getYearWithHighestPopulation = function(populationData)
{       
    var populationByYear = {};
    
    _.each(populationData, function(person)
    {
        for(var i = person["birthYear"]; i <= person["deathYear"]; i++)
        {
            populationByYear[i] = !populationByYear[i] ? 1 : populationByYear[i]+1;
        }    
    }); 
    
    var max = _.max(populationByYear, function(year){return year});
    var highestPopYears = "";
    _.each(populationByYear, function(year, key){
        if(year === max) 
            highestPopYears += " "+key;
    });    
    
    return "Highest population achieved was "+max+" during the year(s) "+highestPopYears;
};
 
console.log(getYearWithHighestPopulation(populationData));
