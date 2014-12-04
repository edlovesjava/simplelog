Ext.application({
    name: 'Sencha',

    launch: function() {

        Ext.create('Ext.data.TreeStore', {
                        type: 'tree',

            storeId: 'TreeStore',
            fields: [
                'id', 'recrodedOn', 'incident', 'feeling', 'resolution',
                {name: 'leaf', defaultValue: true}
            ],
            root: {
                leaf: false
            },
            proxy: {
                type: 'ajax',
                url: '/api/logmessages',
                reader: {
                    type: 'json',
                    rootProperty: '_embedded.logmessages'
                }
            }
        });        
        Ext.create("Ext.tab.Panel", {
            fullscreen: true,
            tabBarPosition: 'bottom',

            items: [
                {
                    title: 'Home',
                    iconCls: 'home',
                    cls: 'home',
                    html: [
                        '',
                        'Welcome to Simple Feeling log',
                        "This log is based on Pia Melody's description of feeling  ",
                        "one up and one down. Record incidents that make you one up or one down ",
                        "and how you resolved these feelings. ",
                        'Wentware'
                    ].join("")
                },
                {
                    xtype: 'nestedlist',
                    title: 'Log',
                    iconCls: 'star',
                    displayField: 'incident',

                    store: 'TreeStore',

                    detailCard: {
                        xtype: 'panel',
                        scrollable: true,
                        styleHtmlContent: true
                    },

                    listeners: {
                        itemtap: function(nestedList, list, index, element, post) {
                            this.getDetailCard().setHtml(post.get('content'));
                        }
                    }
                },
                // this is the new item
                {
                    title: 'Contact',
                    iconCls: 'user',
                    xtype: 'formpanel',
                    url: 'contact.php',
                    layout: 'vbox',

                    items: [
                        {
                            xtype: 'fieldset',
                            title: 'Contact Us',
                            instructions: '(email address is optional)',
                            height: 285,
                            items: [
                                {
                                    xtype: 'textfield',
                                    label: 'Name'
                                },
                                {
                                    xtype: 'emailfield',
                                    label: 'Email'
                                },
                                {
                                    xtype: 'textareafield',
                                    label: 'Message'
                                }
                            ]
                        },
                        {
                            xtype: 'button',
                            text: 'Send',
                            ui: 'confirm',
                            handler: function() {
                                this.up('formpanel').submit();
                            }
                        }
                    ]
                }
            ]
        });
    }
});
