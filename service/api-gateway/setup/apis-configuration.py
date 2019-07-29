#/usr/bin/python

import requests
import json

kongHost = 'localhost'
kongPort = '8001'

services = [
    {
        'name': 'account-service-sys-users',
        'url': 'http://account-service:8080/sys/users'
    },
    {
        'name': 'mail-service-sys-mails',
        'url': 'http://mail-service:8080/sys/mails'
    },
    {
        'name': 'photo-service-sys-photos',
        'url': 'http://photo-service:8080/sys/photos'
    }
]

apis = [
    {
        'name' : 'sysApi.users',
        'paths': ['/sys/v1/users'],
        'hosts': ['http://account-service:8080/sys/users']
    },
    {
        'name' : 'sysApi.mails',
        'paths': ['/sys/v1/mails'],
        'hosts': ['http://mail-service:8080/sys/mails']
    },
    {
        'name' : 'sysApi.photos',
        'paths': ['/sys/v1/photos'],
        'hosts': ['http://photo-service:8080/sys/photos']
    }
]

def getServiceByName(_serviceName):
    kongApi = 'http://' + kongHost + ':' + kongPort + '/services/' + _serviceName
    res = requests.get(url=kongApi)
    if res.status_code == 200:
        return res.json()
    return None


def addService(_name, _url):
    service = getServiceByName(_name)
    if service is not None:
        return service['id']
    kongApi = 'http://' + kongHost + ':' + kongPort + '/services/'
    body = {
        'name': _name,
        'url': _url
    }
    res = requests.post(url = kongApi, data=body)
    if res.status_code == 201:
        print 'Add service [' + _name + '] [' + _url + '] --> OK'
        return res.json()['id']
    print 'Add service [' + _name + '] [' + _url + '] --> FAILED'
    return None

def addApis(_apis):
    for api in _apis:
        serviceId = addService(api['name'], api['hosts'][0])

        print 'Created serviceId = ' + serviceId

        kongApi = 'http://' + kongHost + ':' + kongPort + '/routes'
        data = {
            'name': api['name'],
            'paths': api['paths'],
            'service': {
                'id': serviceId
            }
        }
        headers = {
            'Content-Type': 'application/json',
        }
        res = requests.post(url=kongApi, data=json.dumps(data), headers=headers)
        print res.json()
        if res.status_code == 201:
            print 'Add api ['+ api['name'] +'] --> OK'
        else:
            print'Add api [' + api['name'] + '] --> FAILED'
            break

addApis(apis)
print 'DONE'