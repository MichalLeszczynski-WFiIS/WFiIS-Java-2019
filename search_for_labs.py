import requests
import sys
import time

if len(sys.argv) < 2:
    print("Please provide a number of the lab you wish to download eg:")
    print(sys.argv[0] + " 7")
    sys.exit(1)

start_time = time.time()
n = sys.argv[1]
prefix = "http://www.ftj.agh.edu.pl/~Malinowski/"

extensions = [".java", ".txt", ".pdf", ".zip"]
base_names = ["lab" + n, "lab0" + n]

n_success = 0
n_requests = 0
for base_name in base_names:
    for extension in extensions:
        n_requests += 1
        filename = base_name + extension
        link = prefix + filename
        r = requests.get(link)
        if r.ok:
            n_success += 1
            print(r.url + "\tOK")
            with open(filename, "wb") as f:
                f.write(r.content)

print(
    "Downloaded {} files out of {} in {} s.".format(
    n_success,
    n_requests,
    time.time() - start_time)
)
