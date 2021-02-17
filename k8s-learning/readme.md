

<b>GKE Service Account</b>
gke-sa

Docker commands:
docker build -t k8s-learning .
docker run -p 8080:8080 k8s-learning
docker ps
//to push images to container registry
docker tag k8s-learning gcr.io/<project name>/k8s-learning
docker push

gcloud auth activate-service-account <gke sa>  --key-file=~/sn-gcp-1.json
gcloud auth configure-docker

gcloud projects get-iam-policy <project name>  \
--flatten="bindings[].members" \
--format='table(bindings.role)' \
--filter="bindings.members:service-1007751054795@containerregistry.iam.gserviceaccount.com"

gcloud projects add-iam-policy-binding <project name> \
--member=serviceAccount:service-<projectname>@containerregistry.iam.gserviceaccount.com --role=roles/containerregistry.ServiceAgent

Authenticate/Access Kubectl:
gcloud container clusters get-credentials sn-cluster-1 --zone=europe-west1-b
//its not part of gcloud sdk - so installing on demand in my machine
gcloud components install kubectl

Commands:
kubectl get pods
kubectl get services
kubectl delete f nginx-pod.yaml //deletes a pod from cluster.

To get into a pod interactively:
kubectl exec -it <multi-pod> -c <ftp-container> -- /bin/bash

To simulate pod delete and check recovery:
kubectl delete pod <pod>

To add few more custom columns to get pods output
kubectl get pods -o=custom-columns=NODE:.spec.nodeName,NAME:.metadata.name 

To simulate Node down scenario:
- Tell kube not to schedule the node:
kubectl taint nodes <NODE> key=value:NoSchedule
- Delete the pod running on that node (even after deletion k8s should maintain replicas)
kubectl delete pod <POD>
- To untaint node:
kubectl taint nodes <NODE> key:NoSchedule-
  
To know rollout status / history:
kubectl rollout status
kubectl rollout history
    
